# Cowboy Sunset — Seamless Loop Animation

A lightweight, pure HTML/CSS/SVG animation that loops infinitely without visible jumps. It animates a warm cartoon western sunset town scene with:

- Sun lowering and rising in a seamless cycle
- Soft drifting clouds with parallax
- Subtle heat shimmer refraction
- Gentle cactus/plant sway

No JavaScript required. Honors reduced-motion preferences.

## Getting started

1. Place your background image at `assets/desert-town.jpg` (use the provided scene image or your own 16:9 desktop-friendly art).
2. Open `index.html` in a browser, or serve the folder locally:

```bash
python3 -m http.server -d ./cowboy-sunset 8000
```

Then visit `http://localhost:8000`.

## Art guidelines

- Recommended aspect ratio: 16:9 (e.g., 2560×1440). The layout scales responsively.
- Keep the sun position roughly centered-upper so the animated overlay aligns naturally with the mountains.
- Ensure the horizon and mountains sit in the lower half; the CSS pins the image to `center bottom`.

## Customize

Open `styles.css` and tweak these variables:

- `--loop-duration`: full loop length for the sun
- `--cloud-speed-a/b/c`: drift speeds per cloud layer
- Gradient colors: `--sky-top`, `--sky-mid`, `--sky-low`

Animation keyframes you can tune:

- `@keyframes sun-drift`: adjust vertical offsets to match your image
- `@keyframes cloud-pan`: change travel amount if you alter widths
- `@keyframes sway`: tweak degrees for stronger/weaker breeze

Heat shimmer is an SVG filter (`#heatShimmer`) applied to the backdrop; change `baseFrequency`, `numOctaves`, or the animated `scale` for intensity.

## Accessibility

Respects `prefers-reduced-motion: reduce`; motion effects are disabled automatically.

## File structure

```
cowboy-sunset/
  index.html
  styles.css
  README.md
  assets/
    desert-town.jpg   # supply this
```

