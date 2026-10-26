
package com.kasamamo.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
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

    private LinearLayout content;
    private String currentCategory = "";
    private String lastScreen = "home";

    private final List<Recipe> recipes = new ArrayList<>();
    private final List<PriceEntry> prices = new ArrayList<>();

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

    private static class PriceEntry {
        String item, store;
        double price;

        PriceEntry(String item, String store, double price) {
            this.item = item;
            this.store = store;
            this.price = price;
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
                "Chicken, soy sauce, vinegar, garlic, onion, pepper, bay leaves.",
                "Brown chicken. Add garlic, soy sauce, vinegar, pepper and bay leaves. Add water and simmer until tender. Reduce the sauce.",
                "Adjust vinegar and soy sauce to taste.");

        add("Chicken", "Chicken Tinola", "50 minutes",
                "Chicken, ginger, garlic, onion, green papaya or sayote, malunggay or chili leaves, fish sauce, water.",
                "Sauté ginger, garlic and onion. Add chicken and fish sauce. Add water and simmer. Add papaya or sayote. Add leaves near the end.",
                "Serve hot with rice.");

        add("Chicken", "Chicken Afritada", "50 minutes",
                "Chicken, tomato sauce, potatoes, carrots, bell pepper, onion, garlic, water.",
                "Brown chicken. Sauté garlic and onion. Add tomato sauce and water. Simmer with potatoes and carrots. Add bell pepper.",
                "Cut vegetables evenly.");

        add("Chicken", "Filipino Fried Chicken", "40 minutes",
                "Chicken, garlic, salt, pepper, calamansi, flour, cooking oil.",
                "Season chicken with garlic, salt, pepper and calamansi. Coat lightly with flour. Fry until golden and fully cooked.",
                "Make sure the center is fully cooked.");

        add("Chicken", "Chicken Inasal", "60 minutes",
                "Chicken, calamansi, vinegar, garlic, ginger, lemongrass, annatto oil, salt, pepper.",
                "Marinate chicken with seasonings. Grill while turning. Brush with annatto oil until cooked.",
                "Serve with rice and calamansi.");

        add("Chicken", "Chicken Curry", "50 minutes",
                "Chicken, coconut milk, curry powder, potatoes, carrots, bell pepper, onion, garlic.",
                "Sauté garlic and onion. Brown chicken. Add curry powder and water. Simmer with potatoes and carrots. Add coconut milk and bell pepper.",
                "Keep the heat low after adding coconut milk.");

        // FILIPINO PORK
        add("Pork", "Pork Adobo", "60 minutes",
                "Pork, soy sauce, vinegar, garlic, pepper, bay leaves, water.",
                "Combine pork, soy sauce, garlic, pepper and bay leaves. Simmer until tender. Add vinegar and water. Cook until the sauce reduces.",
                "Simmer until the pork is tender.");

        add("Pork", "Pork Sinigang", "60 minutes",
                "Pork, tamarind soup base, tomato, onion, radish, eggplant, kangkong, water.",
                "Boil pork until tender. Add tomato and onion. Add radish and souring mix. Add remaining vegetables and simmer until cooked.",
                "Adjust the sourness to taste.");

        add("Pork", "Pork Menudo", "60 minutes",
                "Pork, tomato sauce, potatoes, carrots, bell pepper, garlic, onion, water. Liver optional.",
                "Sauté garlic and onion. Brown pork. Add tomato sauce and water. Simmer until tender. Add potatoes, carrots and bell pepper.",
                "Liver is optional.");

        add("Pork", "Bicol Express", "45 minutes",
                "Pork, coconut milk, chili, shrimp paste, garlic, onion, ginger.",
                "Sauté garlic, onion and ginger. Add pork and brown. Add coconut milk and simmer. Stir in shrimp paste and chili. Cook until tender.",
                "Adjust chili to your preferred heat.");

        // BEEF
        add("Beef", "Bistek Tagalog", "45 minutes",
                "Beef slices, soy sauce, calamansi, onion rings, garlic, pepper, water.",
                "Marinate beef in soy sauce, calamansi and pepper. Sauté onion rings and set aside. Cook beef with garlic. Add marinade and water. Simmer and top with onions.",
                "Slice beef thinly across the grain.");

        add("Beef", "Beef Kare-Kare", "120 minutes",
                "Beef or oxtail, peanut butter, ground toasted rice, eggplant, sitaw, pechay, garlic, onion.",
                "Boil beef until tender. Sauté garlic and onion. Add broth, peanut butter and ground rice. Simmer until thick. Add cooked vegetables.",
                "Serve with bagoong on the side.");

        add("Beef", "Bulalo", "180 minutes",
                "Beef shank, corn, cabbage, pechay, onion, peppercorns, water.",
                "Simmer beef shank until tender, skimming the broth. Add onion and pepper. Add corn. Add cabbage and pechay near the end.",
                "A pressure cooker can shorten cooking time.");

        // FISH
        add("Fish", "Paksiw na Isda", "30 minutes",
                "Fish, vinegar, garlic, ginger, onion, pepper, eggplant, water.",
                "Arrange fish in a pot. Add vinegar, garlic, ginger, onion, pepper and water. Bring to a boil. Simmer gently until cooked.",
                "Avoid stirring too much.");

        add("Fish", "Sinigang na Isda", "35 minutes",
                "Fish, tamarind soup base, tomato, onion, radish, okra, kangkong, water.",
                "Boil water with tomato and onion. Add radish and souring mix. Add fish carefully. Simmer until cooked. Add leafy vegetables last.",
                "Choose firm-fleshed fish.");

        add("Fish", "Escabecheng Tilapia", "40 minutes",
                "Tilapia, vinegar, sugar, carrot, bell pepper, onion, garlic, ginger, oil.",
                "Season and fry tilapia. Sauté garlic, ginger, onion, carrot and bell pepper. Add vinegar, sugar and water. Simmer and pour over fish.",
                "Balance sweet and sour flavors.");

        add("Fish", "Grilled Fish with Calamansi", "30 minutes",
                "Fish, calamansi, garlic, salt, pepper, oil.",
                "Clean and season fish with calamansi, garlic, salt and pepper. Grill, turning carefully, until fully cooked.",
                "Pat fish dry before grilling.");

        // SEAFOOD
        add("Seafood", "Garlic Butter Shrimp", "20 minutes",
                "Shrimp, butter, garlic, calamansi or lemon, salt, pepper.",
                "Melt butter and sauté garlic. Add shrimp and cook until pink and opaque. Season and finish with calamansi.",
                "Avoid overcooking shrimp.");

        add("Seafood", "Adobong Pusit", "35 minutes",
                "Squid, vinegar, soy sauce, garlic, onion, tomato, pepper, bay leaf.",
                "Clean squid. Sauté garlic, onion and tomato. Add squid and seasonings. Simmer until just tender.",
                "Squid can become tough if overcooked.");

        add("Seafood", "Sinigang na Hipon", "30 minutes",
                "Shrimp, tamarind soup base, tomato, onion, radish, okra, kangkong, water.",
                "Boil water with tomato and onion. Add radish and souring mix. Add shrimp and cook until pink. Add vegetables and simmer.",
                "Add shrimp near the end.");

        add("Seafood", "Halabos na Hipon", "20 minutes",
                "Shrimp, water, salt, calamansi.",
                "Place shrimp in a covered pan with a small amount of water and salt. Steam until pink and fully cooked. Serve with calamansi.",
                "Shrimp releases its own juices.");

        add("Seafood", "Ginataang Alimasag", "45 minutes",
                "Crab, coconut milk, garlic, onion, ginger, chili, salt, pepper.",
                "Sauté garlic, onion and ginger. Add crab and coconut milk. Cover and cook thoroughly. Add chili and season to taste.",
                "Cook crabs thoroughly.");

        add("Seafood", "Chili Garlic Crab", "35 minutes",
                "Crab, garlic, chili, oil, butter, soy sauce, calamansi, water.",
                "Sauté garlic and chili. Add crab and a little water. Cover and cook thoroughly. Season with soy sauce and calamansi.",
                "Cooking time depends on crab size.");

        // VEGETABLES
        add("Vegetables", "Ginisang Monggo", "45 minutes",
                "Mung beans, garlic, onion, tomato, malunggay or spinach, water.",
                "Boil mung beans until soft. Sauté garlic, onion and tomato. Add beans and broth. Simmer and add greens at the end.",
                "Skip meat for a meat-free version.");

        add("Vegetables", "Pinakbet", "35 minutes",
                "Squash, eggplant, okra, sitaw, ampalaya, tomato, onion, garlic, bagoong, water.",
                "Sauté garlic, onion and tomato. Add bagoong and water. Add firm vegetables first, then remaining vegetables. Cover and cook until tender.",
                "Use locally available vegetables.");

        add("Vegetables", "Chopsuey", "30 minutes",
                "Cabbage, carrots, cauliflower, sayote, bell pepper, green beans, garlic, onion, broth.",
                "Sauté garlic and onion. Add carrots and firm vegetables. Add broth. Add cabbage and bell pepper. Cook until crisp-tender.",
                "Avoid overcooking the vegetables.");

        add("Vegetables", "Ginataang Kalabasa at Sitaw", "35 minutes",
                "Squash, sitaw, coconut milk, garlic, onion, ginger, salt, pepper.",
                "Sauté garlic, onion and ginger. Add squash and coconut milk. Simmer until partly tender. Add sitaw and cook until tender.",
                "Add a little water if needed.");

        add("Vegetables", "Laing", "50 minutes",
                "Dried taro leaves, coconut milk, garlic, onion, ginger, chili.",
                "Simmer coconut milk with garlic, onion and ginger. Add taro leaves and simmer gently until fully tender. Season and add chili.",
                "Cook taro leaves thoroughly; do not eat them raw or undercooked.");

        add("Vegetables", "Tortang Talong", "30 minutes",
                "Eggplant, eggs, salt, pepper, oil.",
                "Grill or boil eggplant until soft. Peel and flatten. Dip in beaten seasoned egg. Pan-fry both sides until cooked.",
                "Add cooked minced meat if desired.");

        add("Vegetables", "Adobong Sitaw", "25 minutes",
                "Sitaw, garlic, onion, soy sauce, vinegar, pepper, water.",
                "Sauté garlic and onion. Add sitaw. Add soy sauce, vinegar, pepper and water. Simmer until tender but still firm.",
                "Tofu can be added for protein.");

        add("Vegetables", "Ginisang Sayote", "20 minutes",
                "Sayote, garlic, onion, tomato, salt, pepper, oil, water.",
                "Sauté garlic, onion and tomato. Add sliced sayote and a little water. Season, cover and cook until tender.",
                "Peel and prepare sayote carefully.");

        add("Vegetables", "Ginisang Ampalaya", "25 minutes",
                "Ampalaya, eggs, garlic, onion, tomato, salt, pepper, oil.",
                "Slice ampalaya and remove seeds. Sauté garlic, onion and tomato. Add ampalaya. Add beaten eggs and cook until set.",
                "Soaking sliced ampalaya briefly in salted water may reduce bitterness.");

        add("Vegetables", "Lumpiang Gulay", "40 minutes",
                "Lumpia wrappers, cabbage, carrots, bean sprouts, green beans, garlic, onion, oil.",
                "Sauté garlic and onion. Add vegetables and cook briefly. Cool the filling, wrap, and fry until crisp.",
                "Drain the filling before wrapping.");

        add("Vegetables", "Ginataang Langka", "45 minutes",
                "Young unripe jackfruit, coconut milk, garlic, onion, ginger, chili.",
                "Boil jackfruit until tender and drain. Sauté garlic, onion and ginger. Add jackfruit and coconut milk. Simmer until flavorful.",
                "Use young, unripe jackfruit.");

        add("Vegetables", "Ensaladang Talong", "25 minutes",
                "Eggplant, tomato, onion, vinegar or calamansi, salt, pepper.",
                "Grill or boil eggplant until soft. Peel and chop. Mix with tomato and onion. Season with vinegar or calamansi.",
                "Serve as a side dish.");

        add("Vegetables", "Ginisang Repolyo with Egg", "20 minutes",
                "Cabbage, eggs, garlic, onion, carrot, oil, salt, pepper.",
                "Sauté garlic and onion. Add carrot and cabbage. Stir-fry until tender-crisp. Add beaten eggs and cook until set.",
                "An easy budget-friendly dish.");

        add("Vegetables", "Dinengdeng", "35 minutes",
                "Saluyot or leafy greens, squash, okra, eggplant, tomato, onion, bagoong, water.",
                "Boil water with onion and tomato. Add bagoong. Add firm vegetables first and leafy greens last. Simmer until cooked.",
                "Vegetables vary by region.");

        add("Vegetables", "Garlic Green Beans", "15 minutes",
                "Green beans, garlic, oil, salt, pepper, optional soy sauce.",
                "Trim beans. Sauté garlic in oil. Add beans and stir-fry until crisp-tender. Season to taste.",
                "A quick vegetable side dish.");

        add("Vegetables", "Roasted Mixed Vegetables", "35 minutes",
                "Carrots, potatoes, broccoli, cauliflower, oil, garlic, salt, pepper.",
                "Cut vegetables evenly. Toss with oil, garlic and seasonings. Roast at 200°C until tender and browned, turning once.",
                "Cooking time varies by vegetable size.");

        // RICE AND NOODLES
        add("Rice & Noodles", "Pancit Bihon", "35 minutes",
                "Rice noodles, chicken or pork, cabbage, carrots, garlic, onion, soy sauce, broth.",
                "Sauté garlic and onion. Cook meat. Add vegetables, broth and soy sauce. Add softened bihon and toss until cooked.",
                "Avoid soaking rice noodles too long.");

        add("Rice & Noodles", "Pancit Canton", "30 minutes",
                "Canton noodles, chicken or pork, cabbage, carrots, green beans, garlic, onion, soy sauce, broth.",
                "Sauté garlic and onion. Cook meat and vegetables. Add broth and seasonings. Add noodles and toss until cooked.",
                "Add broth gradually.");

        add("Rice & Noodles", "Arroz Caldo", "50 minutes",
                "Rice, chicken, ginger, garlic, onion, fish sauce, broth, calamansi, spring onion.",
                "Sauté ginger, garlic and onion. Add chicken and rice. Add broth. Simmer, stirring, until rice is soft. Season and garnish.",
                "Add hot water if it becomes too thick.");

        add("Rice & Noodles", "Garlic Fried Rice", "15 minutes",
                "Cooked rice, garlic, oil, salt, spring onion.",
                "Break up cold rice. Sauté garlic in oil. Add rice and stir-fry until hot. Season and garnish.",
                "Refrigerate leftover rice promptly.");

        // INTERNATIONAL
        add("International", "Japanese Chicken Teriyaki", "30 minutes",
                "Chicken, soy sauce, sugar or honey, ginger, garlic, water, oil.",
                "Cook chicken in a pan. Mix soy sauce, sugar, ginger, garlic and water. Add sauce and simmer until chicken is cooked and sauce thickens.",
                "Serve with rice and vegetables.");

        add("International", "Japanese Vegetable Yakisoba", "25 minutes",
                "Noodles, cabbage, carrots, onion, green beans, soy sauce, oil.",
                "Cook noodles. Stir-fry vegetables. Add noodles and sauce. Toss until heated through.",
                "Use seasonal vegetables.");

        add("International", "Korean Bibimbap", "40 minutes",
                "Rice, carrots, spinach, mushrooms, bean sprouts, egg, soy sauce, sesame oil, optional gochujang.",
                "Cook rice. Prepare vegetables separately. Cook an egg. Arrange toppings over rice. Add sauce and mix before eating.",
                "Gochujang is optional.");

        add("International", "Korean Bulgogi-Style Beef", "35 minutes",
                "Thin beef slices, soy sauce, garlic, sugar, onion, pepper.",
                "Mix soy sauce, garlic, sugar, onion and pepper. Marinate beef. Stir-fry until fully cooked.",
                "Slice beef thinly.");

        add("International", "Thai Vegetable Curry", "30 minutes",
                "Mixed vegetables, coconut milk, curry paste, onion, garlic, oil.",
                "Sauté onion and garlic. Stir in curry paste. Add coconut milk and vegetables. Simmer until tender.",
                "Check the curry paste's spice level.");

        add("International", "Chinese Stir-Fried Vegetables", "20 minutes",
                "Broccoli, carrots, cabbage, mushrooms, garlic, soy sauce, oil, water.",
                "Sauté garlic. Add firm vegetables first. Add mushrooms and cabbage. Add soy sauce and a little water. Stir-fry until crisp-tender.",
                "Avoid overcrowding the pan.");

        add("International", "Italian Tomato Pasta", "30 minutes",
                "Pasta, tomatoes or tomato sauce, garlic, onion, oil, salt, pepper, optional basil.",
                "Cook pasta. Sauté garlic and onion. Add tomatoes or sauce and simmer. Toss with pasta and season.",
                "Save a little pasta water for the sauce.");

        add("International", "Indian Chickpea Curry", "35 minutes",
                "Cooked chickpeas, tomato, onion, garlic, ginger, curry powder, coconut milk or water.",
                "Sauté onion, garlic and ginger. Add curry powder and tomato. Add chickpeas and coconut milk or water. Simmer until thick.",
                "Serve with rice.");

        add("International", "Vegetable Fried Rice", "20 minutes",
                "Cooked rice, carrots, peas, corn, cabbage, garlic, soy sauce, optional egg.",
                "Sauté garlic and vegetables. Add rice and soy sauce. Stir-fry until hot. Add cooked egg if desired.",
                "Use rice that has been stored safely.");

        add("International", "Spaghetti Bolognese", "45 minutes",
                "Spaghetti, ground beef, tomato sauce, onion, garlic, oil, salt, pepper, Italian herbs.",
                "Cook spaghetti. Sauté onion and garlic. Brown beef. Add tomato sauce and herbs. Simmer and serve over pasta.",
                "Simmer sauce for deeper flavor.");
    }

    private void add(String category, String name, String time,
                     String ingredients, String steps, String tip) {
        recipes.add(new Recipe(category, name, time, ingredients, steps, tip));
    }

    private void setupPage(String heading) {
        LinearLayout root = new LinearLayout(this);
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
        subtitle.setTextSize(18);
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
                android.content.res.ColorStateList.valueOf(
                        Color.rgb(46, 125, 70)));
        button.setTextColor(Color.WHITE);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 0, 5);
        content.addView(button, params);
        button.setOnClickListener(v -> action.run());
    }

    // HOME: all eight original feature columns
    private void showHome() {
        currentCategory = "";
        lastScreen = "home";
        setupPage("Your everyday helper");

        addText("ANONG ULAM?", 24, true);
        addText("Your songs, your food, your everyday helper.", 16, false);
        addText("Choose a feature:", 17, true);

        addButton("1. Ano'ng Ulam?", this::showFoodCategories);
        addButton("2. Saan Papunta?", this::showDirections);
        addButton("3. Gawa Dokumento", this::showDocumentMaker);
        addButton("4. Scan to PDF", this::showScanner);
        addButton("5. Send Files", this::showSendFiles);
        addButton("6. Bantay Presyo", this::showPrices);
        addButton("7. Nasaan Sila?", this::showLocationSharing);
        addButton("8. Iwas Scam", this::showScamChecker);
    }

    // FEATURE 1: RECIPES
    private void showFoodCategories() {
        lastScreen = "categories";
        setupPage("Ano'ng Ulam?");

        addText("Filipino and international recipes", 16, false);

        String[] categories = {
                "Chicken", "Pork", "Beef", "Fish", "Seafood",
                "Vegetables", "Rice & Noodles", "International"
        };

        for (String category : categories) {
            addButton(category + " (" + countRecipes(category) + ")",
                    () -> showCategory(category));
        }

        addButton("Search Recipes", this::showSearch);
        addButton("Home", this::showHome);
    }

    private int countRecipes(String category) {
        int count = 0;
        for (Recipe r : recipes) {
            if (r.category.equals(category)) count++;
        }
        return count;
    }

    private void showCategory(String category) {
        currentCategory = category;
        lastScreen = "category";
        setupPage(category + " Recipes");

        for (Recipe r : recipes) {
            if (r.category.equals(category)) {
                addButton(r.name + " • " + r.time, () -> showRecipe(r));
            }
        }

        addButton("Back to Categories", this::showFoodCategories);
        addButton("Home", this::showHome);
    }

    private void showRecipe(Recipe r) {
        lastScreen = "recipe";
        setupPage(r.name);

        addText("Category: " + r.category, 15, true);
        addText("Estimated time: " + r.time, 16, false);
        addText("INGREDIENTS", 20, true);
        addText(r.ingredients, 16, false);
        addText("COOKING INSTRUCTIONS", 20, true);
        addText(r.steps, 16, false);
        addText("KASAMA MO TIP", 20, true);
        addText(r.tip, 16, false);
        addText("Cooking times are estimates. Cook meat, fish and seafood thoroughly.",
                14, false);

        addButton("Back to " + r.category, () -> showCategory(r.category));
        addButton("All Categories", this::showFoodCategories);
        addButton("Home", this::showHome);
    }

    private void showSearch() {
        lastScreen = "search";
        setupPage("Search Recipes");

        EditText input = new EditText(this);
        input.setHint("Dish or ingredient");
        content.addView(input);

        addButton("Search", () -> {
            String query = input.getText().toString().trim()
                    .toLowerCase(Locale.ROOT);
            if (query.isEmpty()) {
                input.setError("Enter a dish or ingredient");
                return;
            }
            showSearchResults(query);
        });

        addButton("Home", this::showHome);
    }

    private void showSearchResults(String query) {
        lastScreen = "searchResults";
        setupPage("Recipe Search Results");
        int count = 0;

        for (Recipe r : recipes) {
            String searchable = (r.name + " " + r.category + " "
                    + r.ingredients).toLowerCase(Locale.ROOT);
            if (searchable.contains(query)) {
                count++;
                addButton(r.name + " • " + r.category, () -> showRecipe(r));
            }
        }

        if (count == 0) addText("No matching recipes found.", 16, false);
        else addText(count + " matching recipes", 15, false);

        addButton("Search Again", this::showSearch);
        addButton("Home", this::showHome);
    }

    // FEATURE 2: MAPS
    private void showDirections() {
        lastScreen = "directions";
        setupPage("Saan Papunta?");
        addText("Find a place using a map app.", 16, false);

        EditText place = new EditText(this);
        place.setHint("Place or address");
        place.setSingleLine(true);
        content.addView(place);

        addButton("Find on Map", () -> {
            String query = place.getText().toString().trim();
            if (query.isEmpty()) {
                place.setError("Enter a destination");
                return;
            }

            Uri uri = Uri.parse("https://www.google.com/maps/search/?api=1&query="
                    + Uri.encode(query));
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        });

        addButton("Home", this::showHome);
    }

    // FEATURE 3: DOCUMENT WRITER
    private void showDocumentMaker() {
        lastScreen = "document";
        setupPage("Gawa Dokumento");

        EditText title = new EditText(this);
        title.setHint("Document title");
        content.addView(title);

        EditText body = new EditText(this);
        body.setHint("Write your document here");
        body.setMinLines(6);
        body.setGravity(Gravity.TOP);
        content.addView(body);

        addButton("Share Document Text", () -> {
            String text = body.getText().toString().trim();
            if (text.isEmpty()) {
                body.setError("Write something first");
                return;
            }

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_SUBJECT,
                    title.getText().toString().trim());
            share.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(share, "Share document"));
        });

        addText("This version shares document text. Exporting formatted DOCX or PDF requires an additional document generator.",
                14, false);
        addButton("Home", this::showHome);
    }

    // FEATURE 4: PDF PICKER
    private void showScanner() {
        lastScreen = "scanner";
        setupPage("Scan to PDF");

        addText("Choose an existing PDF, or open a scanning app if one is installed.",
                16, false);
        addText("This starter screen does not yet capture pages with its own camera scanner.",
                14, false);

        addButton("Choose Existing PDF", () -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.setType("application/pdf");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(intent, 402);
        });

        addButton("Open Camera", () -> {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "No camera app available.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        addButton("Home", this::showHome);
    }

    // FEATURE 5: FILE SHARING
    private void showSendFiles() {
        lastScreen = "sendFiles";
        setupPage("Send Files");

        addText("Choose a file from your device and share it through an installed app.",
                16, false);

        addButton("Choose a File", () -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(intent, 501);
        });

        addButton("Home", this::showHome);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK || data == null
                || data.getData() == null) return;

        Uri uri = data.getData();

        if (requestCode == 501) {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("*/*");
            share.putExtra(Intent.EXTRA_STREAM, uri);
            share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(share, "Send file"));
        } else if (requestCode == 402) {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("application/pdf");
            share.putExtra(Intent.EXTRA_STREAM, uri);
            share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(share, "Share PDF"));
        }
    }

    // FEATURE 6: PRICE COMPARISON
    private void showPrices() {
        lastScreen = "prices";
        setupPage("Bantay Presyo");

        addText("Enter prices you see in stores or markets to compare them.",
                16, false);
        addText("Prices are user-entered. This version does not fetch verified live market prices.",
                14, false);

        EditText item = new EditText(this);
        item.setHint("Product name and size (e.g. rice, 1 kg)");
        content.addView(item);

        EditText store = new EditText(this);
        store.setHint("Store or market name");
        content.addView(store);

        EditText price = new EditText(this);
        price.setHint("Price in pesos");
        price.setInputType(InputType.TYPE_CLASS_NUMBER
                | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        content.addView(price);

        addButton("Add Price", () -> {
            String product = item.getText().toString().trim();
            String shop = store.getText().toString().trim();
            String value = price.getText().toString().trim();

            if (product.isEmpty() || shop.isEmpty() || value.isEmpty()) {
                Toast.makeText(this, "Complete all fields.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double amount = Double.parseDouble(value);
                if (amount < 0) {
                    price.setError("Enter a valid price");
                    return;
                }

                prices.add(new PriceEntry(product, shop, amount));
                showPrices();
            } catch (NumberFormatException e) {
                price.setError("Enter a valid price");
            }
        });

        addText("YOUR PRICE LIST", 19, true);

        if (prices.isEmpty()) {
            addText("No prices added yet.", 15, false);
        } else {
            for (PriceEntry p : prices) {
                addText(p.item + "\n" + p.store + " — "
                        + String.format(Locale.getDefault(), "₱%.2f", p.price),
                        16, true);
            }
        }

        addButton("Clear Price List", () -> {
            prices.clear();
            showPrices();
        });

        addButton("Home", this::showHome);
    }

    // FEATURE 7: CONSENT-BASED LOCATION SHARING
    private void showLocationSharing() {
        lastScreen = "location";
        setupPage("Nasaan Sila?");

        addText("Share your location through a map or messaging app.",
                16, false);
        addText("This version does not track other people or show their live locations.",
                14, false);

        addButton("Open Map", () -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q="));
            startActivity(intent);
        });

        addButton("Share Location Link", () -> {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT,
                    "Please share your location with me using a trusted map or messaging app.");
            startActivity(Intent.createChooser(share, "Share location request"));
        });

        addButton("Home", this::showHome);
    }

    // FEATURE 8: BASIC SCAM WARNING CHECKER
    private void showScamChecker() {
        lastScreen = "scam";
        setupPage("Iwas Scam");

        addText("Paste a suspicious message or link to check for common warning signs.",
                16, false);

        EditText message = new EditText(this);
        message.setHint("Paste message or link here");
        message.setMinLines(4);
        message.setGravity(Gravity.TOP);
        content.addView(message);

        addButton("Check Warning Signs", () -> {
            String text = message.getText().toString().toLowerCase(Locale.ROOT);

            if (text.trim().isEmpty()) {
                message.setError("Paste a message first");
                return;
            }

            boolean warning =
                    text.contains("send otp")
                    || text.contains("one-time password")
                    || text.contains("password")
                    || text.contains("claim your prize")
                    || text.contains("you won")
                    || text.contains("urgent")
                    || text.contains("verify your account")
                    || text.contains("send money")
                    || text.contains("click here")
                    || text.contains("bank account");

            setupPage("Iwas Scam — Result");

            if (warning) {
                addText("CAUTION: Possible warning signs found.", 20, true);
                addText("Do not share passwords, OTPs or money. Verify the sender independently using official contact details.",
                        16, false);
            } else {
                addText("No listed warning signs detected.", 20, true);
                addText("This does not prove the message is safe. Check the sender and link independently.",
                        16, false);
            }

            addButton("Check Another Message", this::showScamChecker);
            addButton("Home", this::showHome);
        });

        addButton("Home", this::showHome);
    }

    @Override
    public void onBackPressed() {
        if ("recipe".equals(lastScreen)) {
            if (!currentCategory.isEmpty()) {
                showCategory(currentCategory);
            } else {
                showFoodCategories();
            }
        } else {
            showHome();
        }
    }
}
