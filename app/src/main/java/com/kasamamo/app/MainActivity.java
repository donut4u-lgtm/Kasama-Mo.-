
package com.kasamamo.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private LinearLayout content;
    private int darkGreen = Color.rgb(28, 92, 65);
    private int lightGreen = Color.rgb(232, 245, 236);
    private int darkText = Color.rgb(35, 45, 38);

    private static class Recipe {
        String category, name, time, ingredients, steps, tip;

        Recipe(String category, String name, String time,
               String ingredients, String steps, String tip) {
            this.category = category;
            this.name = name;
            this.time = time;
            this.ingredients = ingredients;
            this.steps = steps;
            this.tip = tip;
        }
    }

    private final Recipe[] recipes = {
        new Recipe("Chicken", "Chicken Adobo", "45 minutes",
            "1 kg chicken\n1/2 cup soy sauce\n1/2 cup vinegar\n1 cup water\n6 cloves garlic, crushed\n2 bay leaves\n1 tsp whole peppercorns\n1 tbsp cooking oil",
            "1. Marinate chicken in soy sauce and garlic for 15 minutes.\n\n2. Heat oil in a pot. Brown the chicken lightly.\n\n3. Add the marinade, vinegar, water, bay leaves and peppercorns.\n\n4. Bring to a boil. Do not stir for the first few minutes after adding vinegar.\n\n5. Cover and simmer for 30–35 minutes, until the chicken is fully cooked.\n\n6. Adjust the sauce to taste and serve with rice.",
            "Simmer uncovered at the end if you prefer a thicker sauce."),

        new Recipe("Chicken", "Chicken Tinola", "50 minutes",
            "1 kg chicken, cut into pieces\n1 thumb-sized ginger, sliced\n1 onion, sliced\n3 cloves garlic, crushed\n6 cups water\n1 small green papaya or sayote\n1 bunch malunggay or chili leaves\nFish sauce to taste",
            "1. Heat a little oil in a pot. Sauté garlic, onion and ginger.\n\n2. Add chicken and cook until the outside changes color.\n\n3. Add water and bring to a boil.\n\n4. Lower the heat and simmer until the chicken is cooked and tender.\n\n5. Add papaya or sayote and cook until tender.\n\n6. Season with fish sauce. Add the leaves near the end and serve hot.",
            "Add leafy vegetables last to keep them fresh and green."),

        new Recipe("Chicken", "Chicken Afritada", "50 minutes",
            "1 kg chicken\n2 potatoes, cubed\n1 carrot, sliced\n1 red bell pepper\n1 onion, chopped\n3 cloves garlic\n1 cup tomato sauce\n2 cups water\nCooking oil, salt and pepper",
            "1. Heat oil and lightly brown the chicken.\n\n2. Sauté garlic and onion in the same pot.\n\n3. Return chicken to the pot. Add tomato sauce and water.\n\n4. Cover and simmer until the chicken is nearly cooked.\n\n5. Add potatoes and carrots. Cook until tender.\n\n6. Add bell pepper, season to taste and simmer for a few more minutes.",
            "Cut vegetables into similar sizes so they cook evenly."),

        new Recipe("Chicken", "Filipino Fried Chicken", "40 minutes",
            "1 kg chicken pieces\n1 tsp salt\n1/2 tsp pepper\n1 tsp garlic powder\n1 cup all-purpose flour\n1/2 cup cornstarch\nCooking oil for frying",
            "1. Season chicken with salt, pepper and garlic powder.\n\n2. Mix flour and cornstarch in a bowl.\n\n3. Coat each chicken piece evenly in the flour mixture.\n\n4. Heat oil in a deep pan over medium heat.\n\n5. Fry in batches until golden and fully cooked inside.\n\n6. Drain on a rack or paper towels.",
            "Avoid overcrowding the pan. Chicken must reach 74°C internally."),

        new Recipe("Pork", "Pork Adobo", "60 minutes",
            "1 kg pork belly or shoulder\n1/2 cup soy sauce\n1/3 cup vinegar\n1 cup water\n6 cloves garlic\n2 bay leaves\n1 tsp peppercorns",
            "1. Combine pork, soy sauce and garlic. Marinate for 15 minutes.\n\n2. Place pork and marinade in a pot.\n\n3. Add water, bay leaves and peppercorns.\n\n4. Bring to a boil, then reduce the heat and simmer until tender.\n\n5. Add vinegar and allow it to boil briefly before stirring.\n\n6. Continue simmering until the pork is tender and the sauce suits your taste.",
            "Cooking time depends on the cut and size of the pork pieces."),

        new Recipe("Pork", "Pork Sinigang", "60 minutes",
            "1 kg pork ribs or pork shoulder\n1 onion, quartered\n2 tomatoes, quartered\n1 radish, sliced\n1 eggplant, sliced\n1 bunch kangkong\nSinigang mix according to package directions\nWater and fish sauce",
            "1. Put pork and enough water in a pot. Bring to a boil and skim off the foam.\n\n2. Add onion and tomatoes. Simmer until the pork is tender.\n\n3. Add radish and eggplant.\n\n4. Add sinigang mix according to its package directions.\n\n5. Season with fish sauce.\n\n6. Add kangkong near the end and cook until just wilted.",
            "Taste the broth before adding extra seasoning."),

        new Recipe("Fish", "Paksiw na Isda", "30 minutes",
            "750 g fish, cleaned\n1/2 cup vinegar\n1/2 cup water\n1 thumb-sized ginger, sliced\n4 cloves garlic, crushed\n1 onion, sliced\n1 small eggplant, optional\nPepper and salt to taste",
            "1. Arrange fish, ginger, garlic and onion in a pot.\n\n2. Add vinegar, water, pepper and salt.\n\n3. Bring to a boil without stirring for the first few minutes.\n\n4. Lower the heat and simmer gently until the fish is cooked.\n\n5. Add eggplant if desired and cook until tender.\n\n6. Taste and adjust seasoning before serving.",
            "Handle the fish gently to help keep the pieces intact."),

        new Recipe("Fish", "Sinigang na Isda", "35 minutes",
            "750 g fish steaks or whole fish\n1 onion, quartered\n2 tomatoes, quartered\n1 radish, sliced\n1 bunch kangkong\nSinigang mix according to package directions\nWater and fish sauce",
            "1. Boil water with onion and tomatoes until softened.\n\n2. Add radish and simmer until partly tender.\n\n3. Add sinigang mix according to package directions.\n\n4. Gently add the fish and simmer until fully cooked.\n\n5. Season with fish sauce to taste.\n\n6. Add kangkong at the end and cook until wilted.",
            "Avoid vigorous stirring after adding fish."),

        new Recipe("Vegetables", "Ginisang Monggo", "45 minutes",
            "1 cup mung beans\n5 cups water, plus extra as needed\n3 cloves garlic, chopped\n1 onion, chopped\n2 tomatoes, chopped\n1 cup malunggay or spinach\nFish sauce to taste\nOptional: cooked pork or dried fish",
            "1. Rinse mung beans and remove any debris.\n\n2. Boil beans in water until soft, adding more water if needed.\n\n3. In another pan, sauté garlic, onion and tomatoes.\n\n4. Add the sautéed mixture to the softened beans.\n\n5. Simmer until the consistency is to your liking.\n\n6. Season with fish sauce and stir in leafy vegetables before serving.",
            "Soaking the beans beforehand may shorten cooking time."),

        new Recipe("Vegetables", "Pinakbet", "40 minutes",
            "1 small squash, cubed\n1 eggplant, sliced\n1 bitter melon, sliced\n1 cup okra\n1 cup string beans\n2 tomatoes, chopped\n1 onion, chopped\n1 tbsp bagoong, or to taste\n1/2 cup water",
            "1. Sauté onion and tomatoes in a pot.\n\n2. Add bagoong and stir briefly.\n\n3. Add squash and water. Cover and cook until partly tender.\n\n4. Add string beans, eggplant, okra and bitter melon.\n\n5. Cover and cook until the vegetables are tender but not mushy.\n\n6. Taste before adding extra salt because bagoong is already salty.",
            "Add water only as needed; pinakbet is best when the vegetables retain their shape."),

        new Recipe("Vegetables", "Chopsuey", "30 minutes",
            "2 cups mixed vegetables\n1 small carrot, sliced\n1 small cabbage, chopped\n1 bell pepper, sliced\n1 onion, sliced\n3 cloves garlic, chopped\n1 cup water or stock\n1 tbsp soy sauce\n1 tbsp cornstarch mixed with 2 tbsp water",
            "1. Heat oil in a pan. Sauté garlic and onion.\n\n2. Add carrot and other firm vegetables.\n\n3. Pour in water or stock and soy sauce.\n\n4. Add cabbage and bell pepper. Cook until tender-crisp.\n\n5. Stir the cornstarch mixture and pour it into the pan.\n\n6. Stir until the sauce thickens, then serve.",
            "Keep the vegetables slightly crisp for better texture.")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private void startPage(String title) {
        LinearLayout outer = new LinearLayout(this);
        outer.setOrientation(LinearLayout.VERTICAL);
        outer.setBackgroundColor(Color.WHITE);

        TextView heading = new TextView(this);
        heading.setText(title);
        heading.setTextSize(23);
        heading.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        heading.setTextColor(Color.WHITE);
        heading.setGravity(Gravity.CENTER_VERTICAL);
        heading.setPadding(20, 18, 20, 18);
        heading.setBackgroundColor(darkGreen);
        outer.addView(heading);

        ScrollView scroll = new ScrollView(this);
        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(18, 18, 18, 28);
        scroll.addView(content);
        outer.addView(scroll, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));

        setContentView(outer);
    }

    private void addText(String value, int size, boolean bold) {
        TextView tv = new TextView(this);
        tv.setText(value);
        tv.setTextSize(size);
        tv.setTextColor(darkText);
        tv.setPadding(4, 8, 4, 8);
        if (bold) tv.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        content.addView(tv);
    }

    private void addButton(String label, Runnable action) {
        Button button = new Button(this);
        button.setText(label);
        button.setTextColor(darkGreen);
        button.setAllCaps(false);
        button.setTextSize(16);
        button.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(lightGreen));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 6, 0, 6);
        content.addView(button, params);
        button.setOnClickListener(v -> action.run());
    }

    private void showHome() {
        startPage("Kasama Mo");
        addText("Ang kasama mo sa araw-araw!", 18, true);
        addText("Useful everyday tools for Filipino families.", 15, false);

        addButton("🍲  ANONG ULAM?", () -> showFoodCategories());
        addButton("🛒  BANTAY PRESYO", () -> showPrices());
        addButton("ℹ️  ABOUT KASAMA MO", () -> showAbout());

        addText("ANONG ULAM?", 19, true);
        addText("Choose a food category to browse recipes with ingredients and cooking instructions.", 15, false);

        addText("BANTAY PRESYO", 19, true);
        addText("Check price information and its source before making a buying decision. Verified market data is not connected yet.", 15, false);

        addText("More everyday helpers will be added in future updates.", 14, false);
    }

    private void showFoodCategories() {
        startPage("Anong Ulam?");
        addText("Pumili ng sangkap o food category.", 17, true);
        addText("Tap a category to see recipes, ingredients, preparation time and step-by-step instructions.", 15, false);

        addButton("🍗  Chicken", () -> showCategory("Chicken"));
        addButton("🐖  Pork", () -> showCategory("Pork"));
        addButton("🐟  Fish", () -> showCategory("Fish"));
        addButton("🥬  Vegetables", () -> showCategory("Vegetables"));
        addButton("⬅  Home", () -> showHome());
    }

    private void showCategory(String category) {
        startPage(category + " Recipes");
        addText("Choose a recipe", 18, true);

        int count = 0;
        for (Recipe recipe : recipes) {
            if (recipe.category.equals(category)) {
                count++;
                addButton(recipe.name + "  •  " + recipe.time,
                        () -> showRecipe(recipe));
            }
        }

        if (count == 0) {
            addText("No recipes available in this category yet.", 15, false);
        }

        addButton("⬅  Food Categories", () -> showFoodCategories());
        addButton("⌂  Home", () -> showHome());
    }

    private void showRecipe(Recipe recipe) {
        startPage(recipe.name);
        addText("Preparation and cooking time: " + recipe.time, 15, true);
        addText("INGREDIENTS", 19, true);
        addText(recipe.ingredients, 16, false);
        addText("COOKING INSTRUCTIONS", 19, true);
        addText(recipe.steps, 16, false);
        addText("TIP", 19, true);
        addText(recipe.tip, 16, false);

        addButton("⬅  Back to Recipes",
                () -> showCategory(recipe.category));
        addButton("⌂  Home", () -> showHome());
    }

    private void showPrices() {
        startPage("Bantay Presyo");
        addText("Presyo ng bilihin sa Pilipinas", 19, true);
        addText("The nationwide market-price feature is being prepared.", 16, false);

        addText("PLANNED LOCATION FILTERS", 18, true);
        addText("Region → Province → City/Municipality → Public Market", 15, false);
        addText("Example: CALABARZON → Quezon → Sariaya → Sariaya Public Market", 15, false);

        addText("PLANNED PRICE TABLE", 18, true);
        addText("Product | Unit | Price | Market/Location | Date Updated", 15, false);

        addText("DATA STATUS", 18, true);
        addText("No verified live market prices are available in this version. No prices are invented or displayed as real.", 16, false);

        addText("Future price records must identify their source and update date. Official suggested retail prices (SRP) must be distinguished from actual public-market prices.", 15, false);

        addText("Sources planned for integration include DTI price advisories and SRP information, plus relevant DA and PSA price monitoring.", 15, false);

        addButton("⬅  Home", () -> showHome());
    }

    private void showAbout() {
        startPage("About Kasama Mo");
        addText("Kasama Mo", 24, true);
        addText("Your everyday companion.", 18, true);
        addText("This starter version includes an offline Filipino recipe guide and an initial Bantay Presyo information screen.", 16, false);
        addText("Verified nationwide market-price data, additional daily helpers and further features still need to be implemented and tested.", 16, false);
        addButton("⬅  Home", () -> showHome());
    }
}
