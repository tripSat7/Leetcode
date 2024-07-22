class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> ingredientsOfRecipe = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            ingredientsOfRecipe.put(recipes[i], ingredients.get(i));
        }

        Set<String> recipesToMake = new HashSet<>(List.of(recipes));
        Set<String> suppliesAvailable = new HashSet<>(List.of(supplies));
        List<String> recipesCanBeMade = new ArrayList<>();

        // Check if each recipe can be made
        // Note that, for checking if the recipe can be made, we might know whether dependent recipe can also be made.
        // For e.g. If we've to make 'Burger' and 'Bread', while checking if 'Burger' can be made, we'll come to know whether we can make 'Bread' too.
        // Hence, we'll come to know whether 'Burger' and 'Bread' can be made in the first iteration itself.
        for (String recipe: recipes) {
            canWeMakeTheRecipe(recipe, recipesToMake, suppliesAvailable, ingredientsOfRecipe, recipesCanBeMade, new HashSet<>());
        }

        return recipesCanBeMade;
    }

    private boolean canWeMakeTheRecipe(String recipe, Set<String> recipesToMake, Set<String> suppliesAvailable,
                                       Map<String, List<String>> ingredientsOfRecipe, List<String> recipesCanBeMade,
                                       Set<String> visited) {

        // If the recipe is available in the supply, we can make it.
        // Note that, we keep updating supply (last 3rd line) if the recipe can be made.
        if (suppliesAvailable.contains(recipe)) {
            return true;
        }

        // One recipe is dependent on another which in turn is dependent on the previous.
        // Recipe cannot be made. For e.g. X --> Y, Y --> X (OR X --> Y --> Z, Z --> X)
        if (visited.contains(recipe)) {
            return false;
        }

        // We don't bother about a recipe which we don't have to make and which is not available in supply too.
        if (!recipesToMake.contains(recipe) && !suppliesAvailable.contains(recipe)) {
            return false;
        }

        visited.add(recipe);
        for (String ingredient: ingredientsOfRecipe.get(recipe)) {
            if (!canWeMakeTheRecipe(ingredient, recipesToMake, suppliesAvailable, ingredientsOfRecipe, recipesCanBeMade, visited)) {
                return false; // If any of the ingredient is not available, we cannot make the recipe
            }
        }

        suppliesAvailable.add(recipe); // This recipe can be ingredient for another recipe, hence update the supply.
        recipesCanBeMade.add(recipe); // Recipe can be made.

        return true;
    }
}