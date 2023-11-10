package org.group16.Model;

void updatehealth(){
    if (enemy.getHealth() > 0) 
    
    {
        enemy.setHealth(enemy .getHealth() - 1);
       
    }
}
Boolean isDead(){
    if (enemy.getHealth() == 0)
    {
        return true;
    }
    else
    {
        return false;
    }```


}

}