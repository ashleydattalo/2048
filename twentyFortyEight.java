import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Random;
import java.awt.Font;


public class twentyFortyEight extends Applet
   implements KeyListener, MouseListener, MouseMotionListener {

   int width, height;
   String s = "";
   
   int[][] grid = new int [4][4];
   
   String debug2 = "";
   
   String strGridMemory = "";
   int [] arrGridMemory = new int [16];
   int[][] gridMemory = new int[4][4];
   
   boolean q = true;
   boolean w = false;
   boolean e = false;
   boolean mini = false;
   
   int u = 0;
   int num = 15;
   int [][][] arrayOfGrids = new int [num][4][4];
   
   boolean circleMode = false;
   boolean rectangleMode = true;
   
   boolean blue = false;
   boolean orginal = false;
   boolean actual = true;
   boolean red = false;
   
   int fourShowsUp = 0;
   int twoShowsUp = 0;
   
   boolean fillGridMode = false;
   
   boolean isDead = false;
   
   boolean canDie = true;
   boolean neverCanDie = false;
   
   public void init() {
      width = getSize().width;
      height = getSize().height;
      setBackground(new Color(230,249,252));
  
      for(int i = 0; i<=3; i++){
          for(int j = 0; j<=3; j++){
           grid[i][j] = 0;
        }
      }
      
      grid[0][0] = 2;
      grid[0][1] = 4;
      grid[0][2] = 8;
      grid[0][3] = 16;
      
      grid[1][0] = 32;
      grid[1][1] = 64;
      grid[1][2] = 128;
      grid[1][3] = 256;
      
      grid[2][0] = 512;
      grid[2][1] = 1024;
      grid[2][2] = 2048;
      grid[2][3] = 4096;
      
      grid[3][0] = 16384;
      grid[3][1] = 8192;
      grid[3][2] = 67108864;
      grid[3][3] = 67108864;
      
      
      addKeyListener( this );
      addMouseListener( this );
      addMouseMotionListener( this );
    }

   public void keyPressed( KeyEvent e ) {}
   public void keyReleased( KeyEvent e ) { }
   public void keyTyped( KeyEvent e ) {
      char c = e.getKeyChar();
      if ( c != KeyEvent.CHAR_UNDEFINED ) {
         s = "" + c;
         repaint();
         e.consume();
      }
      
      if(e.getKeyCode()==39){
          s = "j";
        }
   }

   public void mouseEntered( MouseEvent e ) { }
   public void mouseExited( MouseEvent e ) { }
   public void mouseClicked( MouseEvent e ) {  }
   public void mousePressed( MouseEvent e ) { }
   public void mouseReleased( MouseEvent e ) { }
   public void mouseMoved( MouseEvent e ) { }
   public void mouseDragged( MouseEvent e ) { }
   
   public void moveLeft(){
       int a = 0; int b = 0;
       for(int k = 0; k<=3; k++){
            for (int p = 0; p <= 3; p++){           
                if( grid[k][p] == 0 ){
                    if(p < 3){
                        a = grid[k][p];
                        b = grid[k][p+1];
                        
                        grid[k][p] = b;
                        grid[k][p+1] = a;
                    }
                }
            }
        }
    }
   public void moveRight(){
       int a = 0; int b = 0;
       for(int k = 0; k<=3; k++){
            for (int p = 3; p >=0 ; p--){           
                if( grid[k][p] == 0 ){
                    if(p > 0){
                        a = grid[k][p];
                        b = grid[k][p-1];
                        
                        grid[k][p] = b;
                        grid[k][p-1] = a;
                    }
                }
            }
        }
    }
   public void moveUp(){
        int a = 0; int b = 0;
         for(int p = 0; p<=3; p++){
            for (int k = 0; k <= 3; k++){           
                if( grid[k][p] == 0 ){
                    if(k < 3){
                        a = grid[k][p];
                        b = grid[k+1][p];
                        
                        grid[k][p] = b;
                        grid[k+1][p] = a;
                    }
                }
            }
        }
    }
   public void moveDown(){
      int a = 0; int b = 0;
      for(int p = 0; p<=3; p++){
          for (int k = 3; k >=0 ; k--){           
            if( grid[k][p] == 0 ){
                if(k > 0){
                    a = grid[k][p];
                    b = grid[k-1][p];
                    
                    grid[k][p] = b;
                    grid[k-1][p] = a;
                }
            }
          }
      } 
    }
    
     void createGridMemory(){
        int count = 0;    
        for(int k = 0; k<=3; k++){
            for (int p = 0; p <=3 ; p++){           
                gridMemory[k][p] = grid[k][p];
                strGridMemory = strGridMemory + gridMemory[k][p];
                arrGridMemory[count] = grid[k][p];
                count++;
            }
        }
    }
    
    void doEveryThing(){
        boolean go = false;
        for(int k = 0; k<=3; k++){
            for (int p = 0; p <=3 ; p++){  
                if(gridMemory[k][p] != grid[k][p]){
                    go = true;
                }
            }
        }     
            
        Random rndNumbers = new Random();
        int rndNumberY = 0, rndZeroOrOne = 0, rndNumberX = 0;
                                
        boolean one = false;
        rndZeroOrOne = rndNumbers.nextInt(100);
       
        if(rndZeroOrOne % 2 == 1){
           one = true;
        }
        if(rndZeroOrOne % 2 == 0){
            one = false;
        }
        if(go == true){ 
            if(u <= num -1){
                for(int k = 0; k<=3; k++){
                    for (int p = 0; p <=3 ; p++){  
                        arrayOfGrids[u][k][p] = gridMemory[k][p];
                    }
                } 
            }
                if(u >= num){
                    for(int kp = 0; kp <= num-2; kp++){ 
                        for(int k = 0; k<=3; k++){
                            for (int p = 0; p <=3 ; p++){  
                                arrayOfGrids[kp][k][p] = arrayOfGrids[kp + 1][k][p];
                                arrayOfGrids[num-1][k][p] = gridMemory[k][p];
                            }
                        } 
                    }
                }
                    if(u <= num -1){
                        u++;
                    } 
            int countNum = 0;        
            for(int l = 0; l<=200; l++){
                rndNumberY = rndNumbers.nextInt(3);
                rndNumberX = rndNumbers.nextInt(3);
                if(grid[rndNumberY][rndNumberX] == 0){
                    break;
                }
                countNum++;
            }
            //g.drawString("NumberY: " + rndNumberY, 95, 25);
            //g.drawString("NumberX: " + rndNumberX, 240, 25);
            //g.drawString("countNum: " + countNum, 330, 25);
            boolean addTile = true;
            if(grid[rndNumberY][rndNumberX] != 0){
                for(int k = 0; k<=3; k++){
                    for(int p = 0; p<=3; p++){
                        if(grid[k][p] == 0 && addTile == true && fillGridMode == false){
                            if(one == false){
                                grid[k][p] = 4;
                                addTile = false;
                                go = false;
                                break;
                            }
                            if(one == true){
                                grid[k][p] = 2;
                                addTile = false;
                                go = false;
                                break;
                            } 
                        }
                    }
                }
            }
            if(grid[rndNumberY][rndNumberX] == 0 && fillGridMode == false){
                if(one == false){
                    grid[rndNumberY][rndNumberX] = 4;
                    go = false;
                }
                if(one == true){
                    grid[rndNumberY][rndNumberX] = 2;
                    go = false;
                }
            }
        }
        int countNonZeros = 0;
        boolean fullGrid = false;
        for(int k = 0; k<=3; k++){
            for(int p = 0; p<=3; p++){
                if(grid[k][p] != 0){
                    countNonZeros++;
                }
            }
        }
        if(countNonZeros == 16){
            fullGrid = true;
        }
            boolean horizontallyDead = false;
            boolean verticallyDead = false;
            int countThemH = 0;
            int countThemV = 0;
            for(int k = 0; k<=3; k++){
                for(int p = 0; p<=2; p++){
                    if(fullGrid == true){
                        if(grid[k][p] != grid[k][p+1]){
                            countThemH++;
                            horizontallyDead = true;
                        }
                    }
                }
            }
            for(int p = 0; p<=3; p++){
                for(int k = 0; k<=2; k++){
                    if(fullGrid == true){
                        if(grid[k][p] != grid[k+1][p]){
                            countThemV++;
                            verticallyDead = true;
                        }
                    }
                }
            }
                if(countThemH == 12 && countThemV == 12){
                    isDead = true;
                }
                else{
                    isDead = false;
                }
    }
    
   public void paint( Graphics g ) {
        g.setColor(Color.white);
        g.setColor(Color.black);
        
        //g.drawString(s, 15,15);
        
        for(int i = 0; i< s.length(); i++){
                //g.drawString( "" +i, 100 + i*30,50);
                
                if(s.charAt(s.length()-1) == '7'){
                    neverCanDie = true;
                    canDie = false;
                    g.drawString("Never Can Die Mode is On", 45,45);
                }
                    if(s.charAt(s.length()-1) == '8'){
                        neverCanDie = false;
                        canDie = true;
                        g.drawString("Never Can Die Mode is Off", 45,45);
                    }
                if(s.charAt(s.length()-1) == 'q'){
                    q = true;
                    w = false;
                    e = false;
                    mini = false;
                }
                    if(s.charAt(s.length()-1) == 'w'){
                        q = false;
                        w = true;
                        e = false;
                        mini = false;
                    }
                        if(s.charAt(s.length()-1) == 'e'){
                            q = false;
                            w = false;
                            e = true;
                            mini = false;
                        }
                            if(s.charAt(s.length()-1) == 'm'){
                                q = false;
                                w = false;
                                e = false;
                                mini = true;
                            }
                
                if(s.charAt(s.length()-1) == 'j'){
                    //left
                    int c = 0;
                    createGridMemory();
                    moveLeft();
                        for(int k = 0; k<=3; k++){
                            for (int p = 0; p <= 3; p++){ 
                                if(p < 3){
                                    if(grid[k][p] == grid[k][p+1]){
                                            c = grid[k][p];
                                           
                                            grid[k][p] = 2 * c;
                                            grid[k][p+1] = 0;
                                        }
                                    }
                                }
                        }
                    moveLeft();
                    moveLeft();
                    doEveryThing();
                }
                    if(s.charAt(s.length()-1) == 'i'){
                        //up
                        int c = 0;
                        createGridMemory();
                        moveUp();
                            for(int p = 0; p<=3; p++){
                                for (int k = 0; k <= 3; k++){ 
                                    if(k < 3){
                                        if(grid[k][p] == grid[k+1][p]){
                                                c = grid[k][p];
                                               
                                                grid[k][p] = 2 * c;
                                                grid[k+1][p] = 0;
                                            }
                                        }
                                    }
                            }
                        moveUp();
                        moveUp();
                        doEveryThing();
                                            }
                        if(s.charAt(s.length()-1) == 'k'){
                            //down
                            int c = 0;
                            createGridMemory();
                            moveDown();
                                for(int p = 0; p<=3; p++){
                                    for (int k = 3; k >= 0 ; k--){ 
                                        if(k > 0){
                                            if(grid[k][p] == grid[k-1][p]){
                                                    c = grid[k][p];
                                                   
                                                    grid[k][p] = 2 * c;
                                                    grid[k-1][p] = 0;
                                                }
                                            }
                                        }
                                }
                            moveDown();
                            moveDown();
                            doEveryThing();
                        }
                            if(s.charAt(s.length()-1) == 'l'){
                                //right
                                int c = 0;
                                createGridMemory();
                                moveRight();
                                    for(int k = 0; k<=3; k++){
                                        for (int p = 3; p >= 0 ; p--){ 
                                            if(p > 0){
                                                if(grid[k][p] == grid[k][p-1]){
                                                        c = grid[k][p];
                                                       
                                                        grid[k][p] = 2 * c;
                                                        grid[k][p-1] = 0;
                                                    }
                                            }
                                            }
                                    }
                                moveRight();
                                moveRight();
                                doEveryThing();
                            }
                            boolean space = false;
                                    if(s.charAt(s.length()-1) == ' '){
                                        space = true;
                                        if(fillGridMode == false){
                                            Random rndNumbers = new Random();
                                                for(int k = 0; k<=3; k++){
                                                     for(int p = 0; p<=3; p++){
                                                            grid[k][p] = 0;    
                                                     }       
                                                }
                                            grid[rndNumbers.nextInt(3)][rndNumbers.nextInt(3)] = 2;
                                            grid[rndNumbers.nextInt(3)][rndNumbers.nextInt(3)] = 4;
                                            grid[rndNumbers.nextInt(3)][rndNumbers.nextInt(3)] = 2;
                                            
                                            u = 0;
                                        }
                                        boolean isFour = false;
                                        if(fillGridMode == true){
                                            fillGrid(space);
                                        }
                                        space = false;
                                    }
                                        if(s.charAt(s.length()-1) == 'u'){
                                            if(u>=1){
                                                for(int k = 0; k<=3; k++){
                                                     for(int p = 0; p<=3; p++){
                                                        grid[k][p] = arrayOfGrids[u-1][k][p];
                                                     }      
                                                }
                                                u--;
                                            }
                                        }
                                            if(s.charAt(s.length()-1) == 'c'){
                                                circleMode = true;
                                                rectangleMode = false;
                                            }
                                            if(s.charAt(s.length()-1) == 's'){
                                                circleMode = false;
                                                rectangleMode = true;
                                            }
                                                if(circleMode == false && rectangleMode == true){
                                                        if(q == true && w == false && e == false && mini == false){
                                                            for (int o = 75; o <= 300; o = o+75){
                                                                for (int j = 75; j <= 300; j = j+75){
                                                                    g.setColor(Color.black);
                                                                    g.drawRect(j,o, 75, 75);
                                                                }
                                                            }
                                                        }
                                                            if(q == false && w == true && e == false && mini == false){
                                                                for (int o = 100; o <= 400; o = o+100){
                                                                    for (int j = 100; j <= 400; j = j+100){
                                                                        g.setColor(Color.black);
                                                                        g.drawRect(j,o,100,100);
                                                                    }
                                                                }
                                                            }
                                                                if(q == false && w == false && e == true && mini == false){
                                                                    for (int o = 125; o <= 500; o = o+125){
                                                                        for (int j = 125; j <= 500; j = j+125){
                                                                            g.setColor(Color.black);
                                                                            g.drawRect(j,o,125,125);
                                                                        }
                                                                    }
                                                                }
                                                                    if(q == false && w == false && e == false && mini == true){
                                                                        for (int o = 25; o <= 100; o = o+25){
                                                                            for (int j = 25; j <= 100; j = j+25){
                                                                                g.setColor(Color.black);
                                                                                g.drawRect(j,o,25,25);
                                                                            }
                                                                        }
                                                                    }
                                                }
                                                if(circleMode == true && rectangleMode == false){
                                                        if(q == true && w == false && e == false && mini == false){
                                                            for (int o = 75; o <= 300; o = o+75){
                                                                for (int j = 75; j <= 300; j = j+75){
                                                                    g.setColor(Color.black);
                                                                    g.drawOval(j,o, 75, 75);
                                                                }
                                                            }
                                                        }
                                                            if(q == false && w == true && e == false && mini == false){
                                                                for (int o = 100; o <= 400; o = o+100){
                                                                    for (int j = 100; j <= 400; j = j+100){
                                                                        g.setColor(Color.black);
                                                                        g.drawOval(j,o,100,100);
                                                                    }
                                                                }
                                                            }
                                                                if(q == false && w == false && e == true && mini == false){
                                                                    for (int o = 125; o <= 500; o = o+125){
                                                                        for (int j = 125; j <= 500; j = j+125){
                                                                            g.setColor(Color.black);
                                                                            g.drawOval(j,o,125,125);
                                                                        }
                                                                    }
                                                                }
                                                                    if(q == false && w == false && e == false && mini == true){
                                                                        for (int o = 25; o <= 100; o = o+25){
                                                                            for (int j = 25; j <= 100; j = j+25){
                                                                                g.setColor(Color.black);
                                                                                g.drawOval(j,o,25,25);
                                                                            }
                                                                        }
                                                                    }
                                                }
                                                    if(s.charAt(s.length()-1) == 'b'){
                                                        blue = true;
                                                        orginal = false;
                                                        actual = false;
                                                        red = false;
                                                    }
                                                    if(s.charAt(s.length()-1) == 'o'){
                                                        blue = false;
                                                        orginal = true;
                                                        actual = false;
                                                        red = false;
                                                    }
                                                    if(s.charAt(s.length()-1) == 'a'){
                                                        blue = false;
                                                        orginal = false;
                                                        actual = true;
                                                        red = false;
                                                    }
                                                    if(s.charAt(s.length()-1) == 'r'){
                                                        blue = false;
                                                        orginal = false;
                                                        actual = false;
                                                        red = true;
                                                    }
                                                    
                                                    //rearrange the board into a more desirable position
                                                    // h - left DOWN
                                                    // t - left UP
                                                    // g - right DOWN
                                                    // y - right UP
                                                    
                                                    int [][] gridNew = new int [4][4];
                                                    
                                                    if(s.charAt(s.length()-1) == 'h'){
                                                        //leftDown
                                                        rearrangeBoard();
                                                    }
                                                    if(s.charAt(s.length()-1) == 't'){
                                                        //leftUp
                                                        int [] array = new int [16];
                                                        int countLengthOfArray = 0;
                                                          for(int k = 0; k <= 3; k++){
                                                            for(int p = 0; p <= 3; p++){
                                                                array[countLengthOfArray] = grid[k][p];
                                                                countLengthOfArray++;
                                                            }
                                                        }
                                                        int store = 0, greatest = 0;
                                                        for(int u = 0; u <= array.length - 2; u++){
                                                            for(int o = 0; o <= array.length - 2; o++){
                                                                if(array[o] < array[o+1]){
                                                                    greatest = array[o+1];
                                                                    store = array[o];
                                                                    array[o] = greatest; 
                                                                    array[o+1] = store;
                                                                }
                                                                store = 0; 
                                                                greatest = 0;
                                                            }
                                                        }
                                                        int count = 0;
                                                        for(int k = 0; k <= 3; k++){
                                                            for(int p = 0; p<=3; p++){
                                                                gridNew[k][p] = array[count];
                                                                count++;
                                                            }
                                                        }
                                                            int storeNum = 0;
                                                            int storeBiggerNum = 0;
                                                            int rowNum = 0;
                                                            for(int k = 0; k<=2; k++){
                                                                for(int p = 0; p<=2; p++){
                                                                    rowNum = 1;
                                                                    if(gridNew[rowNum][p] > gridNew[rowNum][p+1]){
                                                                        storeNum = gridNew[rowNum][p+1];
                                                                        storeBiggerNum = gridNew[rowNum][p];
                                                                        
                                                                        gridNew[rowNum][p] = storeNum;
                                                                        gridNew[rowNum][p+1] = storeBiggerNum;
                                                                    }
                                                                    rowNum = 3;
                                                                    if(gridNew[rowNum][p] > gridNew[rowNum][p+1]){
                                                                        storeNum = gridNew[rowNum][p+1];
                                                                        storeBiggerNum = gridNew[rowNum][p];
                                                                        
                                                                        gridNew[rowNum][p] = storeNum;
                                                                        gridNew[rowNum][p+1] = storeBiggerNum;
                                                                    }
                                                                }
                                                            }
                                                            for(int k = 0; k <= 3; k++){
                                                                for(int p = 0; p<=3; p++){
                                                                    grid[k][p] = gridNew[k][p];
                                                                }
                                                            }
                                                    }
                                                    if(s.charAt(s.length()-1) == 'g'){
                                                        //rightDown
                                                        
                                                        int [] array = new int [16];
                                                        int countLengthOfArray = 0;
                                                          for(int k = 0; k <= 3; k++){
                                                            for(int p = 0; p <= 3; p++){
                                                                array[countLengthOfArray] = grid[k][p];
                                                                countLengthOfArray++;
                                                            }
                                                        }
                                                        int store = 0, greatest = 0;
                                                        for(int u = 0; u <= array.length - 2; u++){
                                                            for(int o = 0; o <= array.length - 2; o++){
                                                                if(array[o] < array[o+1]){
                                                                    greatest = array[o+1];
                                                                    store = array[o];
                                                                    array[o] = greatest; 
                                                                    array[o+1] = store;
                                                                }
                                                                store = 0; 
                                                                greatest = 0;
                                                            }
                                                        }
                                                        int count = 0;
                                                        for(int k = 3; k >= 0; k--){
                                                            for(int p = 3; p>=0; p--){
                                                                gridNew[k][p] = array[count];
                                                                count++;
                                                            }
                                                        }
                                                            int storeNum = 0;
                                                            int storeBiggerNum = 0;
                                                            int rowNum = 0;
                                                            for(int k = 0; k<=2; k++){
                                                                for(int p = 0; p<=2; p++){
                                                                    rowNum = 0;
                                                                    if(gridNew[rowNum][p] < gridNew[rowNum][p+1]){
                                                                        storeNum = gridNew[rowNum][p+1];
                                                                        storeBiggerNum = gridNew[rowNum][p];
                                                                        
                                                                        gridNew[rowNum][p] = storeNum;
                                                                        gridNew[rowNum][p+1] = storeBiggerNum;
                                                                    }
                                                                    rowNum = 2;
                                                                    if(gridNew[rowNum][p] < gridNew[rowNum][p+1]){
                                                                        storeNum = gridNew[rowNum][p+1];
                                                                        storeBiggerNum = gridNew[rowNum][p];
                                                                        
                                                                        gridNew[rowNum][p] = storeNum;
                                                                        gridNew[rowNum][p+1] = storeBiggerNum;
                                                                    }
                                                                }
                                                            }
                                                            for(int k = 0; k <= 3; k++){
                                                                for(int p = 0; p<=3; p++){
                                                                    grid[k][p] = gridNew[k][p];
                                                                }
                                                            }
                                                    }
                                                    if(s.charAt(s.length()-1) == 'y'){
                                                        //rightUp
                                                        int [] array = new int [16];
                                                        int countLengthOfArray = 0;
                                                          for(int k = 0; k <= 3; k++){
                                                            for(int p = 0; p <= 3; p++){
                                                                array[countLengthOfArray] = grid[k][p];
                                                                countLengthOfArray++;
                                                            }
                                                        }
                                                        int store = 0, greatest = 0;
                                                        for(int u = 0; u <= array.length - 2; u++){
                                                            for(int o = 0; o <= array.length - 2; o++){
                                                                if(array[o] < array[o+1]){
                                                                    greatest = array[o+1];
                                                                    store = array[o];
                                                                    array[o] = greatest; 
                                                                    array[o+1] = store;
                                                                }
                                                                store = 0; 
                                                                greatest = 0;
                                                            }
                                                        }
                                                        int count = 0;
                                                        for(int k = 0; k <= 3; k++){
                                                            for(int p = 3; p>=0; p--){
                                                                gridNew[k][p] = array[count];
                                                                count++;
                                                            }
                                                        }
                                                            int storeNum = 0;
                                                            int storeBiggerNum = 0;
                                                            int rowNum = 0;
                                                            for(int k = 0; k<=2; k++){
                                                                for(int p = 0; p<=2; p++){
                                                                    rowNum = 1;
                                                                    if(gridNew[rowNum][p] < gridNew[rowNum][p+1]){
                                                                        storeNum = gridNew[rowNum][p+1];
                                                                        storeBiggerNum = gridNew[rowNum][p];
                                                                        
                                                                        gridNew[rowNum][p] = storeNum;
                                                                        gridNew[rowNum][p+1] = storeBiggerNum;
                                                                    }
                                                                    rowNum = 3;
                                                                    if(gridNew[rowNum][p] < gridNew[rowNum][p+1]){
                                                                        storeNum = gridNew[rowNum][p+1];
                                                                        storeBiggerNum = gridNew[rowNum][p];
                                                                        
                                                                        gridNew[rowNum][p] = storeNum;
                                                                        gridNew[rowNum][p+1] = storeBiggerNum;
                                                                    }
                                                                }
                                                            }
                                                            for(int k = 0; k <= 3; k++){
                                                                for(int p = 0; p<=3; p++){
                                                                    grid[k][p] = gridNew[k][p];
                                                                }
                                                            }
                                                    }
                                                    
                                                        if(s.charAt(s.length()-1) == 'v'){
                                                              grid[0][0] = 2;
                                                              grid[0][1] = 4;
                                                              grid[0][2] = 8;
                                                              grid[0][3] = 16;
                                                              
                                                              grid[1][0] = 32;
                                                              grid[1][1] = 64;
                                                              grid[1][2] = 128;
                                                              grid[1][3] = 256;
                                                              
                                                              grid[2][0] = 512;
                                                              grid[2][1] = 1024;
                                                              grid[2][2] = 2048;
                                                              grid[2][3] = 4096;
                                                              
                                                              grid[3][0] = 16384;
                                                              grid[3][1] = 8192;
                                                              grid[3][2] = 4;
                                                              grid[3][3] = 0;
                                                        }
                                                        Random rndNumbers = new Random();
                                                        int rndZ = rndNumbers.nextInt(100);
                                                        if(s.charAt(s.length()-1) == 'z'){
                                                            for(int k = 0; k <= 3; k++){
                                                                for(int p = 0; p <= 3; p++){
                                                                    if(rndZ%2 == 0){
                                                                        if(grid[k][p] == 0){
                                                                            grid[k][p] = 2048;
                                                                        }
                                                                    }
                                                                    if(rndZ%2 != 0){
                                                                        if(grid[k][p] >=2048){
                                                                            //grid[k][p] = 0;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if(s.charAt(s.length()-1) == 'x'){
                                                            for(int k = 0; k <= 3; k++){
                                                                for(int p = 0; p <= 3; p++){
                                                                    if(grid[k][p] == 0){
                                                                        grid[k][p] = 2048;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        int l = 0;
                                                            if(s.charAt(s.length()-1) == '1'){
                                                               l = 2; 
                                                            }
                                                            if(s.charAt(s.length()-1) == '2'){
                                                               l = 4; 
                                                            }
                                                            if(s.charAt(s.length()-1) == '3'){
                                                               l = 8; 
                                                            }
                                                            if(s.charAt(s.length()-1) == '4'){
                                                               l = 16; 
                                                            }
                                                            if(s.charAt(s.length()-1) == '5'){
                                                               l = 32; 
                                                            }
                                                            if(s.charAt(s.length()-1) == '6'){
                                                               l = 64; 
                                                            }
                                                            for(int k = 0; k <= 3; k++){
                                                                for(int p = 0; p <= 3; p++){
                                                                   if(grid[k][p] == l){
                                                                        grid[k][p] = 0;
                                                                    }
                                                                }
                                                            }
                                                                if(s.charAt(s.length()-1) == '`'){
                                                                   for(int k = 0; k <= 3; k++){
                                                                        for(int p = 0; p <= 3; p++){
                                                                           if(grid[k][p] <2048){
                                                                                grid[k][p] = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                
                                                                    int [] arr = new int [16];
                                                                    int countArr = 0;
                                                                    if(s.charAt(s.length()-1) == 'p'){
                                                                       for(int k = 0; k <= 3; k++){
                                                                            for(int p = 0; p <= 3; p++){
                                                                               arr[countArr] = grid[k][p];
                                                                               countArr++;
                                                                            }
                                                                       }
                                                                       //g.drawString("" + countArr, 25, 25);
                                                                       int store = 0, greatest = 0;
                                                                       for(int r = 0; r<arr.length; r++){
                                                                           for(int u = 0; u <= arr.length - 2; u++){
                                                                                for(int o = 0; o <= arr.length - 2; o++){
                                                                                    if(arr[o] < arr[o+1]){
                                                                                        greatest = arr[o+1];
                                                                                        store = arr[o];
                                                                                        arr[o] = greatest; 
                                                                                        arr[o+1] = store;
                                                                                    }
                                                                                    store = 0; 
                                                                                    greatest = 0;
                                                                                }
                                                                           }
                                                                           for(int o = 0; o <= arr.length-2; o++){
                                                                               if(arr[o] == arr[o+1]){
                                                                                  store = arr[o];
                                                                                  arr[o] = store*2; 
                                                                                  arr[o+1] = 0;
                                                                               }
                                                                           }
                                                                        }
                                                                        int count = 0;
                                                                        for(int k = 3; k >= 0; k--){
                                                                            for(int p = 0; p<=3; p++){
                                                                                gridNew[k][p] = arr[count];
                                                                                count++;
                                                                            }
                                                                        }
                                                                        int storeNum = 0;
                                                                        int storeBiggerNum = 0;
                                                                        int rowNum = 0;
                                                                        for(int k = 0; k<=2; k++){
                                                                            for(int p = 0; p<=2; p++){
                                                                                rowNum = 0;
                                                                                if(gridNew[rowNum][p] > gridNew[rowNum][p+1]){
                                                                                    storeNum = gridNew[rowNum][p+1];
                                                                                    storeBiggerNum = gridNew[rowNum][p];
                                                                                    
                                                                                    gridNew[rowNum][p] = storeNum;
                                                                                    gridNew[rowNum][p+1] = storeBiggerNum;
                                                                                }
                                                                                rowNum = 2;
                                                                                if(gridNew[rowNum][p] > gridNew[rowNum][p+1]){
                                                                                    storeNum = gridNew[rowNum][p+1];
                                                                                    storeBiggerNum = gridNew[rowNum][p];
                                                                                    
                                                                                    gridNew[rowNum][p] = storeNum;
                                                                                    gridNew[rowNum][p+1] = storeBiggerNum;
                                                                                }
                                                                            }
                                                                        }
                                                                        for(int k = 0; k <= 3; k++){
                                                                            for(int p = 0; p<=3; p++){
                                                                                grid[k][p] = gridNew[k][p];
                                                                            }
                                                                        }
                                                                    }
                                                                        if(s.charAt(s.length()-1) == 'd'){
                                                                            if(fillGridMode == false){
                                                                                fillGridMode = true;
                                                                            }
                                                                            g.drawString("Fill Grid Mode is on", 45,45);
                                                                        }
                                                                        
                                                                        if(s.charAt(s.length()-1) == 'f'){
                                                                            if(fillGridMode == true){
                                                                                fillGridMode = false;
                                                                            }
                                                                            g.drawString("Fill Grid Mode is off", 45,45);
                                                                        }
                                                                            
                                                                                if(fillGridMode == true){
                                                                                    if(s.charAt(s.length()-1) == 'j'){
                                                                                        fillGrid(false);
                                                                                    }
                                                                                    if(s.charAt(s.length()-1) == 'i'){
                                                                                        fillGrid(false);
                                                                                    }
                                                                                    if(s.charAt(s.length()-1) == 'k'){
                                                                                        fillGrid(false);
                                                                                    }
                                                                                    if(s.charAt(s.length()-1) == 'l'){
                                                                                        fillGrid(false);
                                                                                    }
                                                                                }
                                                                                    if(isDead == true && neverCanDie == true){
                                                                                            rearrangeBoard();
                                                                                    }
                                                                                        
        }   
        Font myFont = new Font("TimesRoman", Font.BOLD, 18);
        g.setFont(myFont);
        int z = 0, u1 = 0, u2 = 0,v = 0;
        if(q == true){
             z = 75;
             u1 = 33;
             u2 = 38;
             v = 45;
        }
            if(w == true){
                 z = 100;
                 u1 = 48;
                 u2 = 52;
                 v = 45;
            }
                if(e == true){
                     z = 125;
                     u1 = 25; 
                     u2 = 68;
                     v = 45;
                }
                    if(mini == true){
                        z = 25;
                        u1 = 5;
                        u2 = 20;
                        myFont = new Font("TimesRoman", Font.BOLD, 8);
                        g.setFont(myFont);
                        v = 15;
                    }
        for(int i = 0; i<=3; i++){
          for(int j = 0; j<=3; j++){
              if( grid[i][j] != 0){
                if(grid[i][j] == 2){
                    if(orginal == true){
                        g.setColor(Color.cyan);
                    }
                        if(blue == true){
                            g.setColor(new Color(192,242,250));
                        }
                            if(actual == true){
                               g.setColor(new Color(247,242,237)); 
                            }
                            if(red == true){
                               g.setColor(new Color(217,217,217)); 
                            }
                                if(rectangleMode == true ){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }
                }
                if(grid[i][j] == 4){
                    if(orginal == true){
                        g.setColor(new Color( 98,129,234));
                    }
                        if(blue == true){
                            g.setColor(new Color(111,220,237));
                        }
                            if(actual == true){
                                g.setColor(new Color(242, 223, 203));
                            }
                            if(red == true){
                               g.setColor(new Color(214,186,189)); 
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }                    
                }
                if(grid[i][j] == 8){
                    if(orginal == true){
                        g.setColor(new Color(30,49,192));
                    }
                        if(blue == true){
                            g.setColor(new Color(67,201,222));
                        }
                            if(actual == true){
                                g.setColor(new Color(247, 173, 124));
                            }
                            if(red == true){
                               g.setColor(new Color(212,155,160)); 
                            }
                                if(rectangleMode == true){
                                     g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }
                            
                }
                if(grid[i][j] == 16){
                    if(orginal == true){
                        g.setColor(Color.green);
                    }
                        if(blue == true){
                            g.setColor(new Color(13,165,189));
                        }
                            if(actual == true){
                                g.setColor(new Color(242, 149, 82));
                            }
                            if(red == true){
                               g.setColor(new Color(212,123,132)); 
                            }
                                if(rectangleMode == true){
                                     g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }
                }
                if(grid[i][j] == 32){
                    if(orginal == true){
                        g.setColor(Color.magenta);
                    }
                        if(blue == true){
                            g.setColor(new Color(9,131,150));
                        }
                            if(actual == true){
                                g.setColor(new Color(250,125,97));
                            }
                            if(red == true){
                               g.setColor(new Color(209,96,107)); 
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }                 
                }
                if(grid[i][j] == 64){
                    if(orginal == true){
                        g.setColor(new Color(191,29,82));
                    }
                        if(blue == true){
                            g.setColor(new Color(8,96,110));
                        }
                            if(actual == true){
                                g.setColor(new Color(250, 85, 0));
                            }
                            if(red == true){
                               g.setColor(new Color(207,64,78)); 
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }
                }
                if(grid[i][j] == 128){
                    if(orginal == true){
                        g.setColor(Color.yellow);
                    }
                        if(blue == true){
                            g.setColor(new Color(3,71,82));
                        }
                            if(actual == true){
                                g.setColor(new Color(250, 250, 91));
                            }
                            if(red == true){
                               g.setColor(new Color(209,36,53)); 
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }                    
                                }
                if(grid[i][j] == 256){
                    if(orginal == true){
                        g.setColor(Color.pink);
                    }
                        if(blue == true){
                            g.setColor(new Color(2,42,48));
                        }
                            if(actual == true){
                                g.setColor(new Color(242, 232, 82));
                            }
                            if(red == true){
                               g.setColor(new Color(168,25,40)); 
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }  
                }
                if(grid[i][j] == 512){
                    if(orginal == true){
                        g.setColor(Color.gray);
                    }
                        if(blue == true){
                            g.setColor(new Color(0,20,23));
                        }
                            if(actual == true){
                                g.setColor(new Color(240, 227, 43));
                            }
                            if(red == true){
                               g.setColor(new Color(138,22,34)); 
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }  
                }
                if(grid[i][j] == 1024){
                    if(orginal == true){
                        g.setColor(Color.blue);
                    }
                        if(blue == true){
                            g.setColor(new Color(0,2,3));
                        }
                            if(actual == true){
                                g.setColor(new Color(250, 219, 45));
                            }
                            if(red == true){
                               g.setColor(new Color(105,19,27)); 
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }  
                }
                if(grid[i][j] == 2048){
                    if(orginal == true){
                        g.setColor(new Color(88,234,173));
                    }
                        if(blue == true){
                            g.setColor(new Color(0,0,0));
                        }
                            if(actual == true){
                                 g.setColor(new Color(250, 230, 10));
                            }
                            if(red == true){
                                 g.setColor(new Color(87,16,22));
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    } 
                }
                if(grid[i][j] == 4096){
                    if(orginal == true){
                        g.setColor(new Color(90,198,79));
                    }
                        if(blue == true){
                            g.setColor(new Color(0,0,0));
                        }
                            if(actual == true){
                                g.setColor(new Color(54, 49, 5));
                            }
                            if(red == true){
                                 g.setColor(new Color(61,10,15));
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }  
                }
                if(grid[i][j] == 8192){
                    if(orginal == true){
                        g.setColor(new Color(210,84,150));
                    }
                        if(blue == true){
                            g.setColor(new Color(0,0,0));
                        }
                            if(actual == true){
                                g.setColor(new Color(48,45,1));
                            }
                            if(red == true){
                                 g.setColor(new Color(38,7,10));
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }  
                }
                if(grid[i][j] == 16384){
                    if(orginal == true){
                        g.setColor(new Color(210,84,150));
                    }
                        if(blue == true){
                            g.setColor(new Color(0,0,0));
                        }
                            if(actual == true){
                                g.setColor(new Color(48,45,1));
                            }
                            if(red == true){
                                 g.setColor(new Color(38,7,10));
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }  
                }
                if(grid[i][j] > 16384){
                    if(orginal == true){
                        g.setColor(new Color(210,84,150));
                    }
                        if(blue == true){
                            g.setColor(new Color(0,0,0));
                        }
                            if(actual == true){
                                g.setColor(new Color(48,45,1));
                            }
                            if(red == true){
                                 g.setColor(new Color(252,0,0));
                            }
                                if(rectangleMode == true){
                                    g.fillRect((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                }
                                    if(circleMode == true){
                                        g.fillOval((z + 1) + z *j, (z + 1) + z * i, (z - 1), (z - 1));
                                    }  
                }
                if(orginal == true){
                    g.setColor(Color.black); 
                }
                if(blue == true){
                    g.setColor(Color.white);
                    if(grid[i][j] == 2 || grid[i][j] == 4){
                        g.setColor(new Color(2,60,79));
                    }
                }
                if(actual == true){
                    g.setColor(Color.black); 
                    if(grid[i][j] == 4096 || grid[i][j] == 8192){
                        g.setColor(Color.white);
                    }
                }
                if(red == true){
                    g.setColor(Color.white);
                }
                if(grid[i][j] >= 2048){
                    g.setColor(new Color(250, 230, 10));
                    g.drawString("You Win", 90,v);
                    g.setColor(Color.white);
                }
                g.drawString( "" + grid[i][j], (z + u1) +z*j , (z + u2) + z*i);
            }
          }
        }
        
        g.setColor(Color.black);
        myFont = new Font("TimesRoman", Font.BOLD,10);
        g.setFont(myFont);
        int countLoop =0;                                                       
            for(int jk = 0; jk< num; jk++){
                for (int o = 0; o <= 3; o++){
                    for (int j = 0; j <= 3; j++){
                        //g.drawString(" " + arrayOfGrids[jk][o][j], 45 + 40*countLoop,400 + 15* jk);
                        countLoop++;
                    }
                }
                countLoop = 0;   
            }
        myFont = new Font("Courier", Font.BOLD,15);
        g.setFont(myFont);
        int i = 15;
        int j = 1;
        int y = 75;
        int x = 450;
        if(e == true){
            x = 700;
        }
        if(w == true){
            x = 550;
        }
        if(q == true){
            x = 450;
        }
        g.drawString("Press: ", x, y + j*i); j++;
            j++;
        g.drawString("j to go left", x, y + j*i);j++;
        g.drawString("i to go up", x, y + j*i);j++;
        g.drawString("l to go right", x, y + j*i);j++;
        g.drawString("k to go down", x, y + j*i);j++;
            j++;
        g.drawString("u for undo", x, y + j*i);j++;
        g.drawString("spacebar for new game", x, y + j*i);j++;
            j++;
        g.drawString("m for mini board", x, y + j*i);j++;
        g.drawString("q for small board", x, y + j*i);j++;
        g.drawString("w for medium board", x, y + j*i);j++;
        g.drawString("e for large board", x, y + j*i);j++;
            j++;
        g.drawString("c for circles pieces instead of square tiles", x, y + j*i);j++;
        g.drawString("s for going back to square tiles", x, y +j*i);j++;
            j++;
        g.drawString("b for blue colors", x, y + j*i);j++;
        g.drawString("r for red colors", x, y + j*i);j++;
        g.drawString("a for normal colors (the orginal colors you started out with)", x, y + j*i);j++;
            j++;
        g.drawString("t for topLeft align", x, y + j*i);j++;
        g.drawString("y for topRight align", x, y + j*i);j++;
        g.drawString("h for bottomLeft align", x, y + j*i);j++;
        g.drawString("g for bottomRight align", x, y + j*i);j++;
            j++;
        g.drawString("1 to delete all 2's", x, y + j*i);j++;
        g.drawString("2 to delete all 4's", x, y + j*i);j++;
        g.drawString("3 to delete all 8's", x, y + j*i);j++;
        g.drawString("4 to delete all 16's", x, y + j*i);j++;
        g.drawString("5 to delete all 32's", x, y + j*i);j++;
        g.drawString("6 to delete all 64's", x, y + j*i);j++;
        g.drawString("` to delete all #'s under 2048", x, y + j*i);j++;
            j++;
        g.drawString("x to fill all empty spaces with 2048", x, y + j*i);j++;
        g.drawString("d to turn Fill Grid mode on", x, y + j*i);j++;
        g.drawString("f to turn Fill Grid mode off", x, y + j*i);j++;   
        g.drawString("p to automatically add all tiles, and put them in the bottom left corner in order from highest to lowest", x, y + j*i);j++;
            j++;
        g.drawString("7 to turn Never Die mode on", x, y + j*i);j++;      
        g.drawString("8 to turn Never Die mode off", x, y + j*i);j++;
    
        }
        
   public void rearrangeBoard(){
        int [] array = new int [16];
        int [][] gridNew = new int [4][4];
        int countLengthOfArray = 0;
          for(int k = 0; k <= 3; k++){
            for(int p = 0; p <= 3; p++){
                array[countLengthOfArray] = grid[k][p];
                countLengthOfArray++;
            }
        }
        int store = 0, greatest = 0;
        for(int u = 0; u <= array.length - 2; u++){
            for(int o = 0; o <= array.length - 2; o++){
                if(array[o] < array[o+1]){
                    greatest = array[o+1];
                    store = array[o];
                    array[o] = greatest; 
                    array[o+1] = store;
                }
                store = 0; 
                greatest = 0;
            }
        }
        int count = 0;
        for(int k = 3; k >= 0; k--){
            for(int p = 0; p<=3; p++){
                gridNew[k][p] = array[count++];
            }
        }
            int storeNum = 0;
            int storeBiggerNum = 0;
            int rowNum = 0;
            for(int k = 0; k<=2; k++){
                for(int p = 0; p<=2; p++){
                    rowNum = 0;
                    if(gridNew[rowNum][p] > gridNew[rowNum][p+1]){
                        storeNum = gridNew[rowNum][p+1];
                        storeBiggerNum = gridNew[rowNum][p];
                        
                        gridNew[rowNum][p] = storeNum;
                        gridNew[rowNum][p+1] = storeBiggerNum;
                    }
                    rowNum = 2;
                    if(gridNew[rowNum][p] > gridNew[rowNum][p+1]){
                        storeNum = gridNew[rowNum][p+1];
                        storeBiggerNum = gridNew[rowNum][p];
                        
                        gridNew[rowNum][p] = storeNum;
                        gridNew[rowNum][p+1] = storeBiggerNum;
                    }
                }
            }
            for(int k = 0; k <= 3; k++){
                for(int p = 0; p<=3; p++){
                    grid[k][p] = gridNew[k][p];
                }
            }
    }
   public void fillGrid (boolean space){
       Random rndNumbersFull = new Random();
       int rndEvenOrOdd = 0;             
       boolean isFour = false;
       rndEvenOrOdd = rndNumbersFull.nextInt(100);
        if(rndEvenOrOdd % 2 == 1){
           isFour = true;
        }
        if(rndEvenOrOdd % 2 == 0){
            isFour = false;
        }
        int a = 0;
        for(int k = 0; k <= 3; k++){
            for(int p = 0; p <= 3; p++){
               if(grid[k][p] == 0 && space == false){
                   if(isFour == false){
                       grid[k][p] = 2;
                   }
                   if(isFour == true){
                       grid[k][p] = 4;
                   }
                }
               if(space == true){
                  if(isFour == false){
                       grid[k][p] = 2;
                   }
                  if(isFour == true){
                       grid[k][p] = 4;
                   } 
                }
            }
        }
    }
}

