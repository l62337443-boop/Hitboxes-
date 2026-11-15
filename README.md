# NOVA Hitbox Expander (Fabric 1.21.11)

A single-player Fabric mod that changes the actual dimensions used for living-entity bounding boxes (players and mobs).

## Default settings
- Enabled by default
- Width multiplier: 2.0x
- Height multiplier: 1.5x
- Press **H** to toggle the expanded dimensions on/off

## Build on GitHub (Android-friendly)
1. Create a new GitHub repository.
2. Upload the contents of this folder to the repository root.
3. Open **Actions** and allow workflows if GitHub asks.
4. Run **Build NOVA Hitbox Expander** (or push a commit and let it run).
5. Open the successful workflow run and download the `nova-hitbox-expander` artifact.
6. Extract the artifact ZIP; the mod JAR is inside `build/libs` (or directly in the artifact contents depending on GitHub's packaging).
7. Put the JAR in your Fabric profile's `mods` folder. Install Fabric API for Minecraft 1.21.11 too.

Requires Java 21 and Fabric Loader 0.19.3 or newer. This changes local single-player entity dimensions; it is not a server-side mod and does not alter remote multiplayer servers.
