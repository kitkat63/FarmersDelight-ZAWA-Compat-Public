# Integration Analysis (User-Provided Requirements)

## Confirmed Priorities
1. Bare-bones implementation first.
2. Process scorpion/tarantula items one-by-one using exact ZAWA file names/IDs provided by user.
3. Add simple cooking routes first (not complex recipes yet).
4. Egg substitution should use tag unification.
5. Diet integration approach is delegated to implementation analysis.

## Bare-Bones Recipe Rules
- Base bug proteins: all scorpion variants, all tarantula variants, mealworms.
- Supported basic cooking methods:
  - Furnace / Smelting
  - Campfire cooking
  - Farmer's Delight stove/skillet-style processing
- Excluded for base bug proteins:
  - Farmer's Delight cooking pot

## Additional Base Compat Requirements
- Cutting board recipe: large meat -> small meat.
- Include ZAWA meats and shellfish (mussels, shrimp, clams) in Farmer's Delight and Diet compatibility mapping.

## Diet Findings from Provided Material
- Food classification is tag-driven with `diet:[group]` item tags.
- `diet:ingredients` can suppress ingredient contribution when default value generation is enabled.
- `diet:special_food` forces group display for non-edible proxy foods.
- Group configuration supports effects/conditions, including thresholds tied to group levels.

## User-Provided Configuration Notes
- `proteins` group defaults and multipliers are neutral at baseline in provided snippet.
- Effects snippet demonstrates conditional penalties/bonuses tied to group thresholds (example shown for sugars).

## Implementation Implication
For this project's first pass, classify bug proteins, meats, and shellfish under protein-aligned Diet tags while keeping recipe complexity low and postponing cultural/fun composite meals until after base workflow validation.


## Tarantula Nutrition Mapping (Current Guideline)
Reference values provided:
- Protein: 5.4g
- Fat: 1.4g
- Carbohydrate: 0.26g

Interpretation for Minecraft balancing (lean-protein profile):
- Hunger target: 4 (2 drumsticks)
- Saturation modifier target: 0.5
- Diet mapping: proteins

This should be used as the baseline for cooked tarantula variants, then tuned in playtesting.


## Scorpion Nutrition Mapping (Current Guideline)
Reference values provided:
- Protein: 4.5g
- Fat: 0.5g
- Carbohydrate: 0.4g
- Salt: 0.1g

Interpretation for Minecraft balancing (leaner than tarantula):
- Hunger target: 3
- Saturation modifier target: 0.35
- Diet mapping: proteins

Use this profile for all cooked scorpion variants once their exact ZAWA item IDs are provided.


## Mealworm Nutrition Mapping (Current Guideline)
Reference values provided:
- Protein: 10-18%
- Fat: 13-15%
- Carbohydrate: 2-4%

Interpretation for Minecraft balancing (protein-dense, higher fat than scorpion):
- Hunger target: 4
- Saturation modifier target: 0.6
- Diet mapping: proteins


## Termite Nutrition Mapping (Current Guideline)
Reference values provided:
- Crude protein (CP): 67%
- Dry matter (DM): 25%
- Fat: 2%

Interpretation for Minecraft balancing (very high protein, low fat):
- Hunger target: 4
- Saturation modifier target: 0.45
- Diet mapping: proteins


## Seafood Diet Workup (Mussels, Shrimp, Clams, Rat)
For base Diet integration, ZAWA seafood proteins are grouped under `proteins` via a compat tag:
- `zawa:shrimp`
- `zawa:mussel` / `zawa:mussels`
- `zawa:clam` / `zawa:clams`

Entries are optional (`required: false`) to tolerate naming differences between ZAWA builds.


Includes optional compat entries for Crabber's Delight cooked seafood items so cross-mod proteins count toward Diet when either mod provides the item IDs.
