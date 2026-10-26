
package com.kasamamo.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {

    private LinearLayout root;
    private LinearLayout content;
    private String currentCategory = "";
    private String searchText = "";

    private final List<Recipe> recipes = new ArrayList<>();

    private static class Recipe {
        String category;
        String name;
        String time;
        String ingredients;
        String steps;
        String tip;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadRecipes();
        showHome();
    }

    private void loadRecipes() {
        // FILIPINO CHICKEN
        add("Chicken", "Chicken Adobo", "45 minutes",
                "Chicken, soy sauce, vinegar, garlic, onion, peppercorns, bay leaves, water.",
                "1. Brown the chicken. 2. Add garlic, soy sauce, vinegar, pepper and bay leaves. 3. Add water and simmer until tender. 4. Reduce the sauce.",
                "Adjust vinegar and soy sauce to your taste.");

        add("Chicken", "Chicken Tinola", "50 minutes",
                "Chicken, green papaya or chayote, ginger, garlic, onion, malunggay or chili leaves, fish sauce, water.",
                "1. Sauté ginger, garlic and onion. 2. Add chicken and fish sauce. 3. Add water and simmer. 4. Add papaya or chayote. 5. Add leaves near the end.",
                "Serve hot with rice.");

        add("Chicken", "Chicken Afritada", "50 minutes",
                "Chicken, tomato sauce, potatoes, carrots, bell pepper, onion, garlic, oil, water.",
                "1. Brown chicken. 2. Sauté garlic and onion. 3. Add tomato sauce and water. 4. Simmer with potatoes and carrots. 5. Add bell pepper.",
                "Cut vegetables into similar-sized pieces.");

        add("Chicken", "Filipino Fried Chicken", "40 minutes",
                "Chicken pieces, garlic, salt, pepper, calamansi or lemon, flour, cooking oil.",
                "1. Season chicken with garlic, salt, pepper and calamansi. 2. Coat lightly with flour. 3. Fry over medium heat until fully cooked and golden.",
                "Make sure chicken is cooked through.");

        add("Chicken", "Chicken Inasal", "60 minutes",
                "Chicken, calamansi, vinegar, garlic, ginger, lemongrass, annatto oil, salt, pepper.",
                "1. Marinate chicken with calamansi, vinegar, garlic, ginger and seasonings. 2. Grill while turning. 3. Brush with annatto oil until cooked.",
                "Serve with rice and calamansi dipping sauce.");

        add("Chicken", "Filipino Chicken Curry", "50 minutes",
                "Chicken, coconut milk, curry powder, potatoes, carrots, bell pepper, onion, garlic.",
                "1. Sauté garlic and onion. 2. Brown chicken. 3. Add curry powder and water. 4. Simmer with potatoes and carrots. 5. Add coconut milk and bell pepper.",
                "Keep the heat low after adding coconut milk.");

        // FILIPINO PORK
        add("Pork", "Pork Adobo", "60 minutes",
                "Pork, soy sauce, vinegar, garlic, peppercorns, bay leaves, water.",
                "1. Combine pork, soy sauce, garlic, pepper and bay leaves. 2. Simmer until tender. 3. Add vinegar and water. 4. Cook until the sauce reduces.",
                "Let the pork simmer until tender.");

        add("Pork", "Pork Sinigang", "60 minutes",
                "Pork, tamarind soup base, tomato, onion, radish, eggplant, kangkong, fish sauce, water.",
                "1. Boil pork until tender. 2. Add tomato and onion. 3. Add radish and other firm vegetables. 4. Add souring mix. 5. Add kangkong near the end.",
                "Adjust the sourness to your preference.");

        add("Pork", "Pork Menudo", "60 minutes",
                "Pork, liver (optional), tomato sauce, potatoes, carrots, bell pepper, garlic, onion, water.",
                "1. Sauté garlic and onion. 2. Brown pork. 3. Add tomato sauce and water. 4. Simmer until tender. 5. Add potatoes, carrots and bell pepper.",
                "You can leave out liver if preferred.");

        add("Pork", "Bicol Express", "45 minutes",
                "Pork, coconut milk, chili, shrimp paste, garlic, onion, ginger.",
                "1. Sauté garlic, onion and ginger. 2. Add pork and cook until lightly browned. 3. Add coconut milk and simmer. 4. Stir in shrimp paste and chili. 5. Cook until tender.",
                "Adjust chili to control the heat.");

        // FILIPINO BEEF
        add("Beef", "Bistek Tagalog", "45 minutes",
                "Beef slices, soy sauce, calamansi, onion rings, garlic, pepper, oil, water.",
                "1. Marinate beef in soy sauce, calamansi and pepper. 2. Sauté onion rings and set aside. 3. Cook beef with garlic. 4. Add marinade and a little water. 5. Simmer and top with onions.",
                "Slice beef thinly across the grain.");

        add("Beef", "Beef Kare-Kare", "120 minutes",
                "Beef or oxtail, peanut butter, ground toasted rice, eggplant, sitaw, pechay, onion, garlic, water.",
                "1. Boil beef until tender. 2. Sauté garlic and onion. 3. Add broth, peanut butter and ground rice. 4. Simmer until thick. 5. Add cooked vegetables.",
                "Serve with bagoong on the side.");

        add("Beef", "Bulalo", "180 minutes",
                "Beef shank, corn, cabbage, pechay, onion, peppercorns, fish sauce, water.",
                "1. Simmer beef shank in water until tender, skimming the broth. 2. Add onion and pepper. 3. Add corn. 4. Add cabbage and pechay near the end.",
                "A pressure cooker can reduce cooking time.");

        // FISH
        add("Fish", "Paksiw na Isda", "30 minutes",
                "Fish, vinegar, garlic, ginger, onion, pepper, eggplant, water.",
                "1. Arrange fish in a pot. 2. Add vinegar, garlic, ginger, onion, pepper and a little water. 3. Bring to a boil. 4. Simmer gently until fish is cooked.",
                "Avoid stirring too much so the fish stays intact.");

        add("Fish", "Sinigang na Isda", "35 minutes",
                "Fish, tamarind soup base, tomato, onion, radish, okra, kangkong, water.",
                "1. Boil water with tomato and onion. 2. Add radish and souring mix. 3. Add fish carefully. 4. Simmer until cooked. 5. Add leafy vegetables last.",
                "Choose a firm-fleshed fish.");

        add("Fish", "Escabecheng Tilapia", "40 minutes",
                "Tilapia, vinegar, sugar, carrot, bell pepper, onion, garlic, ginger, cornstarch (optional), oil.",
                "1. Season and fry tilapia until cooked. 2. Sauté garlic, ginger, onion, carrot and bell pepper. 3. Add vinegar, sugar and water. 4. Simmer and pour over the fish.",
                "Balance sweet and sour flavors to taste.");

        add("Fish", "Grilled Fish with Calamansi", "30 minutes",
                "Whole fish or fillets, calamansi, garlic, salt, pepper, oil.",
                "1. Clean and score whole fish if using. 2. Season with calamansi, garlic, salt and pepper. 3. Grill, turning carefully, until cooked.",
                "Pat the fish dry before grilling.");

        // SEAFOOD
        add("Seafood", "Garlic Butter Shrimp", "20 minutes",
                "Shrimp, butter, garlic, calamansi or lemon, pepper, salt, parsley (optional).",
                "1. Clean the shrimp. 2. Melt butter and sauté garlic. 3. Add shrimp and cook until pink and opaque. 4. Season and finish with calamansi.",
                "Do not overcook shrimp.");

        add("Seafood", "Adobong Pusit", "35 minutes",
                "Squid, vinegar, soy sauce, garlic, onion, tomato, pepper, bay leaf.",
                "1. Clean squid and reserve ink if desired. 2. Sauté garlic, onion and tomato. 3. Add squid and seasonings. 4. Simmer until just tender.",
                "Squid can become tough if overcooked.");

        add("Seafood", "Sinigang na Hipon", "30 minutes",
                "Shrimp, tamarind soup base, tomato, onion, radish, okra, kangkong, water.",
                "1. Boil water with tomato and onion. 2. Add radish and souring mix. 3. Add shrimp and cook until pink. 4. Add okra and kangkong.",
                "Add shrimp near the end to prevent overcooking.");

        add("Seafood", "Halabos na Hipon", "20 minutes",
                "Shrimp, water, salt, garlic (optional), calamansi.",
                "1. Rinse shrimp. 2. Place in a covered pan with a small amount of water and salt. 3. Steam until pink and cooked. 4. Serve with calamansi.",
                "Shrimp releases its own juices as it cooks.");

        add("Seafood", "Ginataang Alimasag", "45 minutes",
                "Crabs, coconut milk, garlic, onion, ginger, chili, salt, pepper.",
                "1. Sauté garlic, onion and ginger. 2. Add crabs and coconut milk. 3. Simmer until crabs are fully cooked. 4. Add chili and season to taste.",
                "Use fully cooked crabs with shells that have changed color.");

        add("Seafood", "Chili Garlic Crab", "35 minutes",
                "Crab, garlic, chili, oil, butter, soy sauce, calamansi, a little water.",
                "1. Clean and prepare crab. 2. Sauté garlic and chili. 3. Add crab and a little water. 4. Cover and cook thoroughly. 5. Season with soy sauce and calamansi.",
                "Cooking time depends on the size of the crab.");

        // VEGETABLES
        add("Vegetables", "Ginisang Monggo", "45 minutes",
                "Mung beans, garlic, onion, tomato, malunggay or spinach, optional tinapa or pork, water.",
                "1. Boil mung beans until soft. 2. Sauté garlic, onion and tomato. 3. Add cooked beans and broth. 4. Simmer. 5. Add greens at the end.",
                "For a meat-free version, skip the pork and fish.");

        add("Vegetables", "Pinakbet", "35 minutes",
                "Squash, eggplant, okra, sitaw, ampalaya, tomato, onion, garlic, bagoong, water.",
                "1. Sauté garlic, onion and tomato. 2. Add bagoong and water. 3. Add firm vegetables first. 4. Add the remaining vegetables. 5. Cover and cook until tender.",
                "Use the vegetables available in your area.");

        add("Vegetables", "Chopsuey", "30 minutes",
                "Cabbage, carrots, cauliflower, sayote, bell pepper, green beans, garlic, onion, broth, cornstarch (optional).",
                "1. Sauté garlic and onion. 2. Add carrots and firm vegetables. 3. Add broth. 4. Add cabbage and bell pepper. 5. Cook until crisp-tender.",
                "Avoid overcooking the vegetables.");

        add("Vegetables", "Ginataang Kalabasa at Sitaw", "35 minutes",
                "Squash, sitaw, coconut milk, garlic, onion, ginger, salt, pepper, optional shrimp.",
                "1. Sauté garlic, onion and ginger. 2. Add squash and coconut milk. 3. Simmer until partly tender. 4. Add sitaw and cook until tender.",
                "Add a little water if the coconut milk becomes too thick.");

        add("Vegetables", "Laing", "50 minutes",
                "Dried taro leaves, coconut milk, garlic, onion, ginger, chili, shrimp paste (optional).",
                "1. Simmer coconut milk with garlic, onion and ginger. 2. Add taro leaves without stirring too much at first. 3. Simmer gently until leaves are fully tender. 4. Season and add chili.",
                "Cook taro leaves thoroughly; never eat them raw or undercooked.");

        add("Vegetables", "Tortang Talong", "30 minutes",
                "Eggplant, eggs, salt, pepper, oil.",
                "1. Grill or boil eggplant until soft. 2. Peel and flatten. 3. Dip in beaten egg seasoned with salt and pepper. 4. Pan-fry both sides until golden and cooked.",
                "Add minced cooked meat if desired.");

        add("Vegetables", "Adobong Sitaw", "25 minutes",
                "Sitaw, garlic, onion, soy sauce, vinegar, pepper, water, optional tofu or pork.",
                "1. Sauté garlic and onion. 2. Add sitaw and stir-fry. 3. Add soy sauce, vinegar, pepper and a little water. 4. Simmer until tender but still firm.",
                "Add tofu for extra protein.");

        add("Vegetables", "Ginisang Sayote", "20 minutes",
                "Sayote, garlic, onion, tomato, oil, salt, pepper, a little water, optional egg or shrimp.",
                "1. Sauté garlic, onion and tomato. 2. Add sliced sayote. 3. Add a little water and season. 4. Cover and cook until tender.",
                "Wear gloves if sayote sap irritates your skin.");

        add("Vegetables", "Ginisang Ampalaya", "25 minutes",
                "Ampalaya, eggs, garlic, onion, tomato, salt, pepper, oil.",
                "1. Slice ampalaya and remove seeds. 2. Sauté garlic, onion and tomato. 3. Add ampalaya and cook briefly. 4. Add beaten eggs and stir until set.",
                "Remove some bitterness by briefly soaking sliced ampalaya in salted water.");

        add("Vegetables", "Lumpiang Gulay", "40 minutes",
                "Lumpia wrappers, cabbage, carrots, bean sprouts, green beans, garlic, onion, oil.",
                "1. Sauté garlic and onion. 2. Add vegetables and cook until just tender. 3. Cool the filling. 4. Wrap in lumpia wrappers. 5. Fry until crisp.",
                "Drain the filling so the wrappers do not become soggy.");

        add("Vegetables", "Ginataang Langka", "45 minutes",
                "Unripe jackfruit, coconut milk, garlic, onion, ginger, chili, salt, optional shrimp paste.",
                "1. Boil jackfruit until tender and drain. 2. Sauté garlic, onion and ginger. 3. Add jackfruit and coconut milk. 4. Simmer until flavors combine.",
                "Use young, unripe jackfruit.");

        add("Vegetables", "Ensaladang Talong", "25 minutes",
                "Eggplant, tomato, onion, vinegar or calamansi, salt, pepper.",
                "1. Grill or boil eggplant until soft. 2. Peel and chop. 3. Mix with tomato and onion. 4. Season with vinegar or calamansi, salt and pepper.",
                "Serve as a side dish with grilled food.");

        add("Vegetables", "Ginisang Repolyo with Egg", "20 minutes",
                "Cabbage, eggs, garlic, onion, carrot, oil, salt, pepper.",
                "1. Sauté garlic and onion. 2. Add carrot and cabbage. 3. Stir-fry until tender-crisp. 4. Add beaten eggs and cook until set.",
                "A quick, budget-friendly vegetable dish.");

        add("Vegetables", "Dinengdeng", "35 minutes",
                "Saluyot or other leafy greens, squash, okra, eggplant, tomato, onion, bagoong, water, optional grilled fish.",
                "1. Boil water with onion and tomato. 2. Add bagoong to taste. 3. Add firm vegetables first. 4. Add leafy greens last. 5. Simmer until cooked.",
                "Vegetables vary by region and availability.");

        add("Vegetables", "Garlic Green Beans", "15 minutes",
                "Green beans, garlic, oil, salt, pepper, soy sauce (optional).",
                "1. Trim green beans. 2. Heat oil and sauté garlic. 3. Add beans and stir-fry until crisp-tender. 4. Season to taste.",
                "A simple international-style vegetable side.");

        add("Vegetables", "Roasted Mixed Vegetables", "35 minutes",
                "Carrots, potatoes, broccoli, cauliflower, oil, garlic, salt, pepper.",
                "1. Cut vegetables into similar-sized pieces. 2. Toss with oil, garlic and seasonings. 3. Roast at 200°C until tender and browned, turning once.",
                "Cooking time varies by vegetable size.");

        // RICE AND NOODLES
        add("Rice & Noodles", "Pancit Bihon", "35 minutes",
                "Rice noodles, chicken or pork, cabbage, carrots, garlic, onion, soy sauce, broth.",
                "1. Sauté garlic and onion. 2. Cook meat. 3. Add vegetables, broth and soy sauce. 4. Add softened bihon and toss until the liquid is absorbed.",
                "Do not soak rice noodles for too long.");

        add("Rice & Noodles", "Pancit Canton", "30 minutes",
                "Canton noodles, chicken or pork, cabbage, carrots, green beans, garlic, onion, soy sauce, broth.",
                "1. Sauté garlic and onion. 2. Cook meat and vegetables. 3. Add broth and seasonings. 4. Add noodles and toss until cooked.",
                "Add broth gradually as needed.");

        add("Rice & Noodles", "Arroz Caldo", "50 minutes",
                "Rice, chicken, ginger, garlic, onion, fish sauce, water or broth, calamansi, spring onion.",
                "1. Sauté ginger, garlic and onion. 2. Add chicken and rice. 3. Add broth or water. 4. Simmer, stirring, until rice becomes thick and soft. 5. Season and garnish.",
                "Add hot water if it becomes too thick.");

        add("Rice & Noodles", "Garlic Fried Rice", "15 minutes",
                "Cold cooked rice, garlic, oil, salt, spring onion (optional).",
                "1. Break up cold rice. 2. Sauté garlic in oil. 3. Add rice and stir-fry until hot. 4. Season and garnish.",
                "Day-old rice gives the best texture.");

        // INTERNATIONAL CUISINE
        add("International", "Japanese Chicken Teriyaki", "30 minutes",
                "Chicken, soy sauce, sugar or honey, ginger, garlic, a little water, oil.",
                "1. Cook chicken in a pan. 2. Mix soy sauce, sugar, ginger, garlic and water. 3. Pour into the pan. 4. Simmer until chicken is cooked and sauce thickens.",
                "Serve with rice and steamed vegetables.");

        add("International", "Japanese Vegetable Yakisoba", "25 minutes",
                "Noodles, cabbage, carrots, onion, green beans, soy sauce, oyster sauce (optional), oil.",
                "1. Cook noodles according to package instructions. 2. Stir-fry vegetables. 3. Add noodles and sauces. 4. Toss until heated through.",
                "Use your favorite seasonal vegetables.");

        add("International", "Korean Bibimbap", "40 minutes",
                "Cooked rice, carrots, spinach, mushrooms, bean sprouts, egg, soy sauce, sesame oil, gochujang (optional).",
                "1. Cook rice. 2. Prepare each vegetable separately. 3. Fry or poach an egg. 4. Arrange vegetables and egg over rice. 5. Add sauce and mix before eating.",
                "Use chili paste only if you enjoy spicy food.");

        add("International", "Korean Bulgogi-Style Beef", "35 minutes",
                "Thin beef slices, soy sauce, garlic, sugar, onion, pepper, sesame oil (optional).",
                "1. Mix soy sauce, garlic, sugar, onion and pepper. 2. Marinate beef. 3. Stir-fry over high heat until cooked. 4. Serve with rice.",
                "Slice beef thinly for faster cooking.");

        add("International", "Thai Vegetable Curry", "30 minutes",
                "Mixed vegetables, coconut milk, curry paste, onion, garlic, oil, water.",
                "1. Sauté onion and garlic. 2. Stir in curry paste. 3. Add coconut milk and vegetables. 4. Simmer until vegetables are tender.",
                "Check curry paste ingredients and heat level.");

        add("International", "Chinese Stir-Fried Vegetables", "20 minutes",
                "Broccoli, carrots, cabbage, mushrooms, garlic, soy sauce, oil, a little water.",
                "1. Heat oil and sauté garlic. 2. Add firm vegetables first. 3. Add mushrooms and cabbage. 4. Add soy sauce and a splash of water. 5. Stir-fry until crisp-tender.",
                "Keep the pan hot and avoid overcrowding.");

        add("International", "Italian Tomato Pasta", "30 minutes",
                "Pasta, tomatoes or tomato sauce, garlic, onion, olive oil, salt, pepper, basil (optional).",
                "1. Cook pasta according to package instructions. 2. Sauté garlic and onion. 3. Add tomatoes or sauce and simmer. 4. Toss with pasta and season.",
                "Save a little pasta water to loosen the sauce.");

        add("International", "Indian Chickpea Curry", "35 minutes",
                "Cooked chickpeas, tomato, onion, garlic, ginger, curry powder, coconut milk or water, oil.",
                "1. Sauté onion, garlic and ginger. 2. Add curry powder and tomato. 3. Add chickpeas and coconut milk or water. 4. Simmer until thick and flavorful.",
                "Serve with rice or flatbread.");

        add("International", "Vegetable Fried Rice", "20 minutes",
                "Cooked rice, carrots, peas, corn, cabbage, egg (optional), garlic, soy sauce, oil.",
                "1. Sauté garlic and vegetables. 2. Add rice and break up clumps. 3. Add soy sauce. 4. Stir-fry until hot. 5. Add cooked egg if desired.",
                "Use leftover rice that has been refrigerated safely.");

        add("International", "Italian Spaghetti Bolognese", "45 minutes",
                "Spaghetti, ground beef, tomato sauce, onion, garlic, oil, salt, pepper, Italian herbs.",
                "1. Cook spaghetti. 2. Sauté onion and garlic. 3. Brown ground beef. 4. Add tomato sauce and herbs. 5. Simmer and serve over pasta.",
                "Simmer the sauce longer for a deeper flavor.");
    }

    private void add(String category, String name, String time,
                     String ingredients, String steps, String tip) {
        recipes.add(new Recipe(category, name, time, ingredients, steps, tip));
    }

    private void setupPage(String heading) {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.rgb(250, 248, 242));

        TextView title = new TextView(this);
        title.setText("Kasama Mo");
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(Color.rgb(35, 105, 65));
        title.setGravity(Gravity.CENTER);
        title.setPadding(16, 20, 16, 6);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText(heading);
        subtitle.setTextSize(17);
        subtitle.setTextColor(Color.DKGRAY);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(12, 0, 12, 16);
        root.addView(subtitle);

        ScrollView scroll = new ScrollView(this);
        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(16, 8, 16, 24);
        scroll.addView(content);
        root.addView(scroll, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));

        setContentView(root);
    }

    private void addText(String text, int size, boolean bold) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextSize(size);
        view.setTextColor(Color.rgb(40, 40, 40));
        view.setPadding(8, 8, 8, 8);
        if (bold) {
            view.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        }
        content.addView(view);
    }

    private void addButton(String text, Runnable action) {
        Button button = new Button(this);
        button.setText(text);
        button.setAllCaps(false);
        button.setTextSize(16);
        button.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(Color.rgb(46, 125, 70)));
        button.setTextColor(Color.WHITE);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 0, 5);
        content.addView(button, params);
        button.setOnClickListener(v -> action.run());
    }

    private void showHome() {
        currentCategory = "";
        setupPage("Your everyday helper");
        addText("ANONG ULAM?", 24, true);
        addText("Discover Filipino favorites, seafood, vegetables and international dishes.", 16, false);

        addButton("Find a Recipe", this::showFoodCategories);
        addButton("Bantay Presyo", this::showPrices);
        addButton("About Kasama Mo", this::showAbout);
    }

    private void showFoodCategories() {
        setupPage("Choose a food category");
        addText("RECIPES", 22, true);

        String[] categories = {
                "Chicken", "Pork", "Beef", "Fish", "Seafood",
                "Vegetables", "Rice & Noodles", "International"
        };

        for (String category : categories) {
            int count = countRecipes(category);
            addButton(category + " (" + count + " recipes)",
                    () -> showCategory(category));
        }

        addButton("Search All Recipes", this::showSearch);
        addButton("Home", this::showHome);
    }

    private int countRecipes(String category) {
        int count = 0;
        for (Recipe recipe : recipes) {
            if (recipe.category.equals(category)) count++;
        }
        return count;
    }

    private void showCategory(String category) {
        currentCategory = category;
        setupPage(category + " Recipes");

        List<Recipe> found = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.category.equals(category)) found.add(recipe);
        }

        addText(found.size() + " recipes available", 15, false);

        for (Recipe recipe : found) {
            addButton(recipe.name + "  •  " + recipe.time,
                    () -> showRecipe(recipe));
        }

        addButton("Back to Categories", this::showFoodCategories);
        addButton("Home", this::showHome);
    }

    private void showSearch() {
        setupPage("Search Recipes");
        addText("Type a dish name or ingredient.", 16, false);

        EditText search = new EditText(this);
        search.setSingleLine(true);
        search.setHint("Example: shrimp, eggplant, pasta");
        content.addView(search);

        addButton("Search", () -> {
            searchText = search.getText().toString().trim()
                    .toLowerCase(Locale.ROOT);

            if (searchText.isEmpty()) {
                Toast.makeText(this, "Enter a dish or ingredient.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            showSearchResults(searchText);
        });

        addButton("Back to Categories", this::showFoodCategories);
        addButton("Home", this::showHome);
    }

    private void showSearchResults(String query) {
        setupPage("Search Results");
        int count = 0;

        for (Recipe recipe : recipes) {
            String searchable = (recipe.name + " " + recipe.category + " "
                    + recipe.ingredients).toLowerCase(Locale.ROOT);

            if (searchable.contains(query)) {
                count++;
                addButton(recipe.name + " • " + recipe.category,
                        () -> showRecipe(recipe));
            }
        }

        if (count == 0) {
            addText("No recipes found for \"" + query + "\".", 16, false);
            addText("Try another dish name or ingredient.", 14, false);
        } else {
            addText(count + " matching recipes", 15, false);
        }

        addButton("Search Again", this::showSearch);
        addButton("Back to Categories", this::showFoodCategories);
        addButton("Home", this::showHome);
    }

    private void showRecipe(Recipe recipe) {
        setupPage(recipe.name);

        addText("Category: " + recipe.category, 15, true);
        addText("Estimated time: " + recipe.time, 16, false);

        addText("INGREDIENTS", 20, true);
        addText(recipe.ingredients, 16, false);

        addText("COOKING INSTRUCTIONS", 20, true);
        addText(recipe.steps, 16, false);

        addText("KASAMA MO TIP", 20, true);
        addText(recipe.tip, 16, false);

        addText("Cooking times are estimates. Make sure meat, fish and seafood are fully cooked.", 14, false);

        addButton("Back to " + recipe.category,
                () -> showCategory(recipe.category));
        addButton("All Categories", this::showFoodCategories);
        addButton("Home", this::showHome);
    }

    private void showPrices() {
        setupPage("Bantay Presyo");
        addText("BANTAY PRESYO", 23, true);
        addText("This starter version does not yet connect to verified live market prices.", 16, false);
        addText("For now, compare prices at your local public market and grocery stores before buying.", 16, false);
        addText("A future version can include market locations, price updates and the date each price was checked.", 16, false);
        addButton("Home", this::showHome);
    }

    private void showAbout() {
        setupPage("About Kasama Mo");
        addText("Kasama Mo", 24, true);
        addText("Your everyday helper.", 18, false);
        addText("This version includes Filipino chicken, pork, beef, fish, seafood, vegetable, rice and noodle recipes, plus international dishes.", 16, false);
        addText("Recipe quantities are not yet standardized for serving sizes. Adjust ingredients to your needs and check for allergies.", 15, false);
        addButton("Explore Recipes", this::showFoodCategories);
        addButton("Home", this::showHome);
    }

    @Override
    public void onBackPressed() {
        if (!currentCategory.isEmpty()) {
            showCategory(currentCategory);
        } else {
            showHome();
        }
    }
}
