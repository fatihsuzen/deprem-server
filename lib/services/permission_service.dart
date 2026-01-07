import 'package:flutter/material.dart';
import 'package:geolocator/geolocator.dart';
import 'package:location/location.dart' as loc;
import '../widgets/location_permission_dialog.dart';

/// Konum izinlerini yöneten merkezi servis
/// Google Play Store politikalarına uygun şekilde izinleri alır
class PermissionService {
  static final PermissionService _instance = PermissionService._internal();
  factory PermissionService() => _instance;
  PermissionService._internal();

  bool _hasShownBackgroundDialog = false;

  /// Temel konum iznini kontrol eder ve gerekiyorsa ister (dialog ile)
  /// [context] Dialog göstermek için gerekli
  /// [showDialog] True ise kullanıcıya açıklama dialog'u gösterilir (varsayılan: true)
  Future<bool> requestLocationPermission(
    BuildContext context, {
    bool showDialog = true,
  }) async {
    try {
      // Önce izin durumunu kontrol et
      LocationPermission permission = await Geolocator.checkPermission();

      if (permission == LocationPermission.denied) {
        if (showDialog && context.mounted) {
          // Kullanıcıya açıklama göster
          final accepted = await LocationPermissionDialog.show(
            context,
            isBackgroundPermission: false,
          );

          if (!accepted) {
            print('[Permission] Kullanıcı konum iznini reddetti');
            return false;
          }
        }

        // İzin iste
        permission = await Geolocator.requestPermission();
      }

      if (permission == LocationPermission.deniedForever) {
        print('[Permission] Konum izni kalıcı olarak reddedildi');
        if (context.mounted) {
          await _showOpenSettingsDialog(context);
        }
        return false;
      }

      return permission == LocationPermission.whileInUse ||
          permission == LocationPermission.always;
    } catch (e) {
      print('[Permission] Konum izni hatası: $e');
      return false;
    }
  }

  /// Arka plan konum iznini kontrol eder ve gerekiyorsa ister (dialog ile)
  /// [context] Dialog göstermek için gerekli
  /// [showDialog] True ise kullanıcıya açıklama dialog'u gösterilir (varsayılan: true)
  Future<bool> requestBackgroundLocationPermission(
    BuildContext context, {
    bool showDialog = true,
  }) async {
    try {
      // Önce normal konum iznini kontrol et
      LocationPermission permission = await Geolocator.checkPermission();

      // Normal konum izni yoksa önce onu al
      if (permission == LocationPermission.denied ||
          permission == LocationPermission.deniedForever) {
        final hasPermission = await requestLocationPermission(
          context,
          showDialog: showDialog,
        );
        if (!hasPermission) {
          return false;
        }
        permission = await Geolocator.checkPermission();
      }

      // Eğer sadece "While in use" izni varsa ve arka plan izni henüz istenmemişse
      if (permission == LocationPermission.whileInUse &&
          !_hasShownBackgroundDialog) {
        if (showDialog && context.mounted) {
          // Kullanıcıya arka plan izni açıklaması göster
          final accepted = await LocationPermissionDialog.show(
            context,
            isBackgroundPermission: true,
          );

          _hasShownBackgroundDialog = true;

          if (!accepted) {
            print('[Permission] Kullanıcı arka plan konum iznini reddetti');
            return false;
          }
        }

        // Arka plan izni iste (Android 10+)
        permission = await Geolocator.requestPermission();
      }

      if (permission == LocationPermission.deniedForever) {
        print('[Permission] Arka plan konum izni kalıcı olarak reddedildi');
        if (context.mounted) {
          await _showOpenSettingsDialog(context, isBackground: true);
        }
        return false;
      }

      return permission == LocationPermission.always;
    } catch (e) {
      print('[Permission] Arka plan konum izni hatası: $e');
      return false;
    }
  }

  /// Location package ile konum izni ister (alternatif method)
  Future<bool> requestLocationPermissionWithLocationPackage(
    BuildContext context, {
    bool showDialog = true,
  }) async {
    try {
      final loc.Location location = loc.Location();

      // Servis kontrolü
      bool serviceEnabled = await location.serviceEnabled();
      if (!serviceEnabled) {
        serviceEnabled = await location.requestService();
        if (!serviceEnabled) {
          return false;
        }
      }

      // İzin kontrolü
      loc.PermissionStatus permissionGranted = await location.hasPermission();
      if (permissionGranted == loc.PermissionStatus.denied) {
        if (showDialog && context.mounted) {
          // Kullanıcıya açıklama göster
          final accepted = await LocationPermissionDialog.show(
            context,
            isBackgroundPermission: false,
          );

          if (!accepted) {
            print('[Permission] Kullanıcı konum iznini reddetti');
            return false;
          }
        }

        permissionGranted = await location.requestPermission();
      }

      return permissionGranted == loc.PermissionStatus.granted;
    } catch (e) {
      print('[Permission] Location package izin hatası: $e');
      return false;
    }
  }

  /// Kullanıcıya ayarlara gitme dialog'u gösterir
  Future<void> _showOpenSettingsDialog(
    BuildContext context, {
    bool isBackground = false,
  }) async {
    if (!context.mounted) return;

    await showDialog(
      context: context,
      builder: (context) => AlertDialog(
        icon: Icon(
          Icons.settings,
          size: 48,
          color: Theme.of(context).colorScheme.primary,
        ),
        title: const Text('İzin Gerekli'),
        content: Text(
          isBackground
              ? 'Arka plan konum izni kalıcı olarak reddedildi. Lütfen uygulama ayarlarından "Konum" iznini "Her zaman izin ver" olarak ayarlayın.'
              : 'Konum izni kalıcı olarak reddedildi. Lütfen uygulama ayarlarından "Konum" iznini aktif edin.',
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.of(context).pop(),
            child: const Text('İptal'),
          ),
          FilledButton(
            onPressed: () async {
              Navigator.of(context).pop();
              await Geolocator.openAppSettings();
            },
            child: const Text('Ayarlara Git'),
          ),
        ],
      ),
    );
  }

  /// İzin durumlarını sıfırlar (test için)
  void resetDialogFlags() {
    _hasShownBackgroundDialog = false;
  }

  /// Mevcut izin durumunu kontrol eder
  Future<LocationPermission> checkCurrentPermission() async {
    return await Geolocator.checkPermission();
  }

  /// Konum servisinin açık olup olmadığını kontrol eder
  Future<bool> isLocationServiceEnabled() async {
    return await Geolocator.isLocationServiceEnabled();
  }
}
