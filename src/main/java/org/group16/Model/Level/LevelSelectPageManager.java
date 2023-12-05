package org.group16.Model.Level;

public class LevelSelectPageManager {
    private int currentPage;
    private final int TOTAL_LEVELS;

    public LevelSelectPageManager(int totalLevels) {
        this.currentPage = 1;
        this.TOTAL_LEVELS = totalLevels;
    }

    public int getCurrentPage(){
        return this.currentPage;
    }

    public void nextPage() {
        int endPage = TOTAL_LEVELS / 4 + 1;

        if (currentPage < endPage) {
            currentPage++;
        }
    }

    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
        }
    }
}
