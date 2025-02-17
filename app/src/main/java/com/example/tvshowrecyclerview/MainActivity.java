package com.example.tvshowrecyclerview;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

import adapter.CharacterAdapter;
import model.Character;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText searchEditText;
    private CharacterAdapter adapter;
    private List<Character> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchEditText = findViewById(R.id.searchEditText);

        // יצירת רשימת דמויות
        characterList = getCharacterList();

        // הגדרת RecyclerView
        adapter = new CharacterAdapter(this, characterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // הוספת מאזין לשדה החיפוש
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private List<Character> getCharacterList() {
        List<Character> list = new ArrayList<>();
        list.add(new Character("SpongeBob SquarePants", "A cheerful and optimistic yellow sea sponge who lives in a pineapple under the sea.", R.drawable.character1));
        list.add(new Character("Squidward Tentacles", "SpongeBob's grumpy and cynical neighbor, an octopus who works as a cashier at the Krusty Krab.", R.drawable.character2));
        list.add(new Character("Patrick Star", "pongeBob's best friend, a simple-minded yet lovable pink starfish who lives under a rock.", R.drawable.character3));
        list.add(new Character("Mr. Krabs", "The money-obsessed owner of the Krusty Krab. A red crab who loves profit, Mr. Krabs is known for his frugality and rivalry with Plankton", R.drawable.character4));
        list.add(new Character("Pearl Krabs", "Mr. Krabs’ teenage whale daughter. Pearl is bubbly, dramatic, and loves shopping and hanging out with her friends.5", R.drawable.character5));
        list.add(new Character("Sandy Cheeks", "A smart and adventurous squirrel from Texas who lives in an underwater dome. Sandy is a scientist and martial artist who enjoys extreme sports.6", R.drawable.character6));
        list.add(new Character("Gary the Snail", "SpongeBob’s loyal pet snail who communicates through meowing. Though he seems simple, Gary is shown to be intelligent and resourceful.7", R.drawable.charater7));
        list.add(new Character("Plankton", "The small, evil genius and owner of the Chum Bucket. Plankton is constantly trying to steal the Krabby Patty secret formula.", R.drawable.charater8));
        list.add(new Character("Mrs. Puff", "SpongeBob’s boating school teacher. A pufferfish with a short temper, Mrs. Puff is frequently stressed due to SpongeBob’s poor driving skills.", R.drawable.character9));
        list.add(new Character("Karen", "Plankton’s sarcastic and intelligent computer wife. Karen often helps with his schemes but also mocks his failures.", R.drawable.character10));

        return list;
    }
    private void filter(String text) {
        List<Character> filteredList = new ArrayList<>();
        for (Character character : characterList) {
            if (character.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(character);
            }
        }
         adapter = new CharacterAdapter(this, filteredList);
         recyclerView.setAdapter(adapter);
    }
}
