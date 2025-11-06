import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class NavSvgIcon extends StatelessWidget {
  final String assetPath;
  final bool selected;
  final double width;
  final double height;
  final String? semanticsLabel;

  const NavSvgIcon({
    Key? key,
    required this.assetPath,
    this.selected = false,
    this.width = 24,
    this.height = 24,
    this.semanticsLabel,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final color = selected ? const Color(0xFFFF3A3D) : Colors.grey;
    return SvgPicture.asset(
      assetPath,
      width: width,
      height: height,
      colorFilter: ColorFilter.mode(color, BlendMode.srcIn),
      semanticsLabel: semanticsLabel,
    );
  }
}
