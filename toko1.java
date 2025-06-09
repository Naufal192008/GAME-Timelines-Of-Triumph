import greenfoot.*;

public class toko1 extends World {
    public toko1() {
        super(900, 600, 1);
        prepareWorld();
        prepare();
    }

    private void prepareWorld() {
        FileManager.muatData();
        BGMPlayer.playLoop();
        setupUI();
        addArtefakButtons();
    }

    private void setupUI() {
        addObject(new BUY(), 50, 50);
        updateTampilanPoin();
    }

    private void addArtefakButtons() {
        
    }

    public void act() {
        updateTampilanPoin();
    }

    public void updateTampilanPoin() {
        showText("Poin: " + GlobalData.poin, 100, 50);
    }

    public void started() {
        BGMPlayer.resume();
    }

    public void stopped() {
        BGMPlayer.pause();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        keris keris = new keris();
        addObject(new ArtefakButton("keris", "menu.png"), 157,182);
        wayang wayang = new wayang();
        addObject(new ArtefakButton("mahkota", "menu (2).png"), 857,117);
        mahkota mahkota = new mahkota();
        addObject(new ArtefakButton("wayang", "menu (3).png"),298,444);
        candi candi = new candi();
        addObject(new ArtefakButton("candi", "menu (1).png"),667,464);

        KE_HOME kE_HOME = new KE_HOME();
        addObject(kE_HOME,864,581);
    }
}