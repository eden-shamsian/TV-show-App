package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tvshowrecyclerview.R;
import model.Character;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private Context context;
    private List<Character> characterList;

    // Constructor
    public CharacterAdapter(Context context, List<Character> characterList) {
        this.context = context;
        this.characterList = characterList;
    }
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.character_item, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);

        holder.nameTextView.setText(character.getName());
        holder.descriptionTextView.setText(character.getDescription());
        holder.imageView.setImageResource(character.getImageResId());

        // מאזין ללחיצה על השורה
        holder.itemView.setOnClickListener(v -> {
            // ניפוח הפריסה המותאמת
            LayoutInflater inflater = LayoutInflater.from(context);
            View dialogView = inflater.inflate(R.layout.custom_dialog, null);

            // יצירת הדיאלוג
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setView(dialogView);

            AlertDialog alertDialog = builder.create();

            // חיבור רכיבי הדיאלוג
            ImageView dialogImage = dialogView.findViewById(R.id.dialogImage);
            TextView dialogTitle = dialogView.findViewById(R.id.dialogTitle);
            TextView dialogDescription = dialogView.findViewById(R.id.dialogDescription);
            Button dialogButton = dialogView.findViewById(R.id.dialogButton);

            // עדכון תוכן הדיאלוג עם פרטי הדמות
            dialogImage.setImageResource(character.getImageResId());
            dialogTitle.setText(character.getName());
            dialogDescription.setText(character.getDescription());

            // פעולה לכפתור הסגירה
            dialogButton.setOnClickListener(v1 -> alertDialog.dismiss());

            // הצגת הדיאלוג
            alertDialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    // ViewHolder Class
    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;
        ImageView imageView;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
