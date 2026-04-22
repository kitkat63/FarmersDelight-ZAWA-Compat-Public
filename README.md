# Farmer's Delight + ZAWA Compat (1.20.1)

## Goal
Create a Forge 1.20.1 compatibility bridge that adds edible/cookable ZAWA bug content and food integrations that feel native with Farmer's Delight, with optional Diet support.

## Baseline Technical Constraints
- Minecraft: **1.20.1**
- Java: **17**
- Gradle: **8.x max**
- Forge: **47.4.16**

## Dependency Policy
- **Required:**
  - Farmer's Delight (`farmersdelight`)
  - ZAWA (`zawa`)
- **Optional soft compat:**
  - Diet (`diet`)

These rules are enforced in `mods.toml`.

## Content Plan (Pre-coding Guideline)
1. **Raw Bug Foods**
   - Add item/tag compatibility so key ZAWA bug drops can be recognized as ingredients.
2. **Cooked Bug Foods**
   - Smelting/campfire/smoker routes where appropriate.
3. **Farmer's Delight-style Dishes**
   - Cutting board, cooking pot, and shapeless/crafting recipes for mixed dishes that include bug proteins + legumes.
4. **Legume Integration**
   - Ensure legumes are valid pairings in new recipes and tags.
5. **Diet Integration (Optional)**
   - If Diet is present, register category assignments for new foods.
6. **Balance/Progression**
   - Keep hunger/saturation aligned with existing Farmer's Delight progression.

## Implementation Notes
- Prefer tag-based compatibility to reduce hard item ID coupling.
- Keep the first pass mostly data-driven (recipes, tags, loot/processing JSON).
- Only add Java hooks when data packs cannot achieve desired behavior.

## Next Build Steps
- Add core mod entrypoint class.
- Add data generators for recipes, tags, and optional Diet compat data.
- Add first recipe batch for ZAWA bugs + legumes + FD cooking systems.


## Confirmed Scope From User Discussion
- Basic cooking support should cover **all scorpion types**, **all tarantula types**, and **mealworms**.
- Basic proteins must cook in:
  - Furnace
  - Campfire
  - Farmer's Delight stove/skillet workflows
- Basic bug proteins should **not** use Farmer's Delight cooking pot recipes.
- Add realistic + fun complex bug-forward recipes, with overall design centered on **protein-heavy foods**.
- Make selected modpack egg items interchangeable with Farmer's Delight egg-based recipes.
- Add cutting board processing: **large meat -> small meat**.
- Ensure ZAWA meats plus mussels, shrimp, and clams are recognized in both Farmer's Delight and Diet integration.

## Next Alignment Step (In Chat)
Before coding data/recipes, we should confirm exact ZAWA item IDs and the egg/meat variants you want included so all recipes are wired correctly on first implementation pass.
