import 'package:flutter/material.dart';
import '../l10n/app_localizations.dart';

/// Google Play Store politikalarına uygun konum izni açıklama dialog'u
/// BACKGROUND_LOCATION iznini istemeden önce kullanıcıya belirgin açıklama gösterir
class LocationPermissionDialog extends StatelessWidget {
  final bool isBackgroundPermission;
  final VoidCallback onAccept;
  final VoidCallback onDeny;

  const LocationPermissionDialog({
    super.key,
    required this.isBackgroundPermission,
    required this.onAccept,
    required this.onDeny,
  });

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);
    final theme = Theme.of(context);

    return AlertDialog(
      icon: Icon(
        Icons.location_on,
        size: 48,
        color: theme.colorScheme.primary,
      ),
      title: Text(
        isBackgroundPermission
            ? localizations!.backgroundLocationTitle
            : localizations!.locationPermissionTitle,
        style: theme.textTheme.titleLarge?.copyWith(
          fontWeight: FontWeight.bold,
        ),
      ),
      content: SingleChildScrollView(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              isBackgroundPermission
                  ? localizations!.backgroundLocationMessage
                  : localizations!.locationPermissionMessage,
              style: theme.textTheme.bodyMedium,
            ),
            const SizedBox(height: 16),
            _buildFeatureItem(
              context,
              Icons.warning_amber,
              isBackgroundPermission
                  ? localizations!.backgroundLocationReason1
                  : localizations!.locationReason1,
            ),
            const SizedBox(height: 8),
            _buildFeatureItem(
              context,
              Icons.notifications_active,
              isBackgroundPermission
                  ? localizations!.backgroundLocationReason2
                  : localizations!.locationReason2,
            ),
            const SizedBox(height: 8),
            _buildFeatureItem(
              context,
              Icons.group,
              isBackgroundPermission
                  ? localizations!.backgroundLocationReason3
                  : localizations!.locationReason3,
            ),
            const SizedBox(height: 16),
            Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: theme.colorScheme.primaryContainer.withOpacity(0.3),
                borderRadius: BorderRadius.circular(8),
              ),
              child: Row(
                children: [
                  Icon(
                    Icons.info_outline,
                    size: 20,
                    color: theme.colorScheme.primary,
                  ),
                  const SizedBox(width: 8),
                  Expanded(
                    child: Text(
                      localizations!.locationPrivacyNote,
                      style: theme.textTheme.bodySmall?.copyWith(
                        color: theme.colorScheme.onSurface.withOpacity(0.8),
                      ),
                    ),
                  ),
                ],
              ),
            ),
            if (isBackgroundPermission) ...[
              const SizedBox(height: 12),
              Text(
                localizations!.backgroundLocationNote,
                style: theme.textTheme.bodySmall?.copyWith(
                  fontStyle: FontStyle.italic,
                  color: theme.colorScheme.primary,
                ),
              ),
            ],
          ],
        ),
      ),
      actions: [
        TextButton(
          onPressed: onDeny,
          child: Text(
            localizations!.deny,
            style: TextStyle(color: theme.colorScheme.error),
          ),
        ),
        FilledButton(
          onPressed: onAccept,
          child: Text(localizations!.allow),
        ),
      ],
    );
  }

  Widget _buildFeatureItem(BuildContext context, IconData icon, String text) {
    final theme = Theme.of(context);
    return Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Icon(
          icon,
          size: 20,
          color: theme.colorScheme.primary,
        ),
        const SizedBox(width: 8),
        Expanded(
          child: Text(
            text,
            style: theme.textTheme.bodyMedium,
          ),
        ),
      ],
    );
  }

  /// Dialog göster ve kullanıcı seçimini döndür
  static Future<bool> show(
    BuildContext context, {
    required bool isBackgroundPermission,
  }) async {
    final result = await showDialog<bool>(
      context: context,
      barrierDismissible: false,
      builder: (context) => LocationPermissionDialog(
        isBackgroundPermission: isBackgroundPermission,
        onAccept: () => Navigator.of(context).pop(true),
        onDeny: () => Navigator.of(context).pop(false),
      ),
    );
    return result ?? false;
  }
}
