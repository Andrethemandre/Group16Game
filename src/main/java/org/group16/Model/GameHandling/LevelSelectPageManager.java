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

    public int getMaxPages(){
        int maxPages = 0;
        
        if(TOTAL_LEVELS % 4 == 0){
            maxPages = TOTAL_LEVELS / 4;
        }
        else{
            maxPages = TOTAL_LEVELS/4 + 1;
        }

        return maxPages;
    }

    public void nextPage() {
        int endPage = getMaxPages();
        
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
