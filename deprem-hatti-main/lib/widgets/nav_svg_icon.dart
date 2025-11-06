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
    final color = selected ? Colors.red : Colors.grey;
    return SvgPicture.asset(
      assetPath,
      width: width,
      height: height,
      color: color,
      semanticsLabel: semanticsLabel,
      // If the SVG has hard-coded stroke/fill colors this will still tint the
      // final picture. For full control convert SVGS to use currentColor or
      // remove inline colors.
    );
  }
}
