package org.group16.Model.GameHandling;

public class LevelSelectPageManager {
    private int currentPage;
    private int selectedLevelNumber;
    private final int TOTAL_LEVELS;

    public LevelSelectPageManager(int totalLevels) {
        this.currentPage = 1;
        this.selectedLevelNumber = 1;
        this.TOTAL_LEVELS = totalLevels;
    }

    public int getCurrentPage(){
        return this.currentPage;
    }

    public int getSelectedLevelNumber(){
        return this.selectedLevelNumber;
    }

    public void setSelectedLevelNumber(int selectedLevelNumber){
        this.selectedLevelNumber = selectedLevelNumber;
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
