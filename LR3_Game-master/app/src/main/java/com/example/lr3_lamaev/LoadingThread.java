package com.example.lr3_lamaev;

public class LoadingThread implements Runnable
{
    private MainActivity mainActivity;
    public LoadingThread(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
    }

    @Override
    public  void run()
    {
        try
        {
            // Имитация задержки на 3-5 секунд
            Thread.sleep(3000);

            // Обновление интерфейса
            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run()
                {
                    // Убираем ProgressBar и показывает ListView
                    mainActivity.hideLoadingProgressBar();
                    mainActivity.showCountriesList();

                    // Инициализация списка и установка адаптера
                    mainActivity.setInitialData();
                    GameAdapter gameAdapter = new GameAdapter(mainActivity, R.layout.list_item, mainActivity.getGames());
                    mainActivity.setCountriesListAdapter(gameAdapter);
                }
            });
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
