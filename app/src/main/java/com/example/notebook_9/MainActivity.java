package com.example.notebook_9;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends Activity
{
    EditText textmsq;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация EditText
        textmsq = (EditText) findViewById(R.id.editText1);
    }

    // Метод для записи текста в файл
    public void WriteBtn (View v) {
        // Добавляю и записываю текст в файл
        try
        {
            FileOutputStream fileout = openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(textmsq.getText().toString());
            outputWriter.close();

            // Отображаю уведомление об успехе
            Toast.makeText(getBaseContext(), "Изменения учтены!", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Метод для чтения текста из файла
    public void ReadBtn(View v)
    {
        // Чтение текста из файла
        try
        {
            FileInputStream fileIn = openFileInput("mytextfile.txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);

            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;

            while ((charRead = InputRead.read(inputBuffer)) > 0)
            {
                // Преобразование char в строку
                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                s += readstring;
            }
            InputRead.close();

            // Устанавливаем текст в EditText
            textmsq.setText(s);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
