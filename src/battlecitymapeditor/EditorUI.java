package battlecitymapeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/**
 *
 * @author JH62
 */
public class EditorUI extends javax.swing.JFrame implements KeyListener, MouseListener, MouseWheelListener {

    public static final ImageIcon BRICKS = new ImageIcon(EditorUI.class.getResource("res/Battle_City_bricks.png"));
    public static final ImageIcon WALL = new ImageIcon(EditorUI.class.getResource("res/Battle_City_wall.png"));
    public static final ImageIcon ICE = new ImageIcon(EditorUI.class.getResource("res/Battle_City_ice.png"));
    public static final ImageIcon TREES = new ImageIcon(EditorUI.class.getResource("res/Battle_City_trees.png"));
    public static final ImageIcon WATER = new ImageIcon(EditorUI.class.getResource("res/Battle_City_water.png"));

    private final Image baseBackground = new ImageIcon(this.getClass().getResource("res/editor_base.png")).getImage();
    private Image background;
    private final int TILE_SIZE = 16;
    private final ButtonGroup buttonGroup1 = new ButtonGroup();

    private ArrayList<Tile> tiles = new ArrayList<>(26);

    private boolean toggleBackground = false;
    private boolean toggleGrid = false;
    private File lastPath = null;

    private Tile.Type selectedType = Tile.Type.BRICKS;

    public EditorUI() {
        initComponents();
        setIconImage(new ImageIcon(this.getClass().getResource("res/icon.png")).getImage());

        addKeyListener(this);
        addMouseListener(this);
        addMouseWheelListener(this);
        jPanel1.addKeyListener(this);
        buttonGroup1.add(buttonBricks);
        buttonGroup1.add(buttonGrass);
        buttonGroup1.add(buttonIce);
        buttonGroup1.add(buttonSteel);
        buttonGroup1.add(buttonWater);

        buttonBricks.addActionListener(buttonGroup1Listener);
        buttonGrass.addActionListener(buttonGroup1Listener);
        buttonIce.addActionListener(buttonGroup1Listener);
        buttonSteel.addActionListener(buttonGroup1Listener);
        buttonWater.addActionListener(buttonGroup1Listener);

        setSelectedIcon("bricks");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonBricks = new javax.swing.JRadioButton();
        buttonSteel = new javax.swing.JRadioButton();
        buttonWater = new javax.swing.JRadioButton();
        buttonIce = new javax.swing.JRadioButton();
        buttonGrass = new javax.swing.JRadioButton();
        selectedTile = new javax.swing.JButton();
        buttonChangeBackground = new javax.swing.JButton();
        buttonGenerate = new javax.swing.JButton();
        jPanel1 = new javax.swing.Box.Filler(new java.awt.Dimension(208, 208), new java.awt.Dimension(208, 208), new java.awt.Dimension(208, 208));
        listRegions = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemClearLevel = new javax.swing.JMenuItem();
        itemToggleOpacity = new javax.swing.JMenuItem();
        itemToggleGrid = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        buttonBricks.setSelected(true);
        buttonBricks.setText("Bricks");
        buttonBricks.setName("bricks"); // NOI18N

        buttonSteel.setText("Wall");

        buttonWater.setText("Water");

        buttonIce.setText("Ice");

        buttonGrass.setText("Trees");
        buttonGrass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGrassActionPerformed(evt);
            }
        });

        selectedTile.setBorder(null);
        selectedTile.setBorderPainted(false);
        selectedTile.setContentAreaFilled(false);
        selectedTile.setFocusable(false);

        buttonChangeBackground.setText("Background");
        buttonChangeBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeBackgroundActionPerformed(evt);
            }
        });

        buttonGenerate.setText("Generate");
        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        listRegions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FULL", "HALF UP", "HALF DOWN", "HALF LEFT", "HALF RIGHT", "SINGLE LEFT UP", "SINGLE LEFT DOWN", "SINGLE RIGHT UP", "SINGLE RIGHT DOWN" }));
        listRegions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listRegionsActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        itemClearLevel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        itemClearLevel.setText("Clear level");
        itemClearLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClearLevelActionPerformed(evt);
            }
        });
        jMenu2.add(itemClearLevel);

        itemToggleOpacity.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        itemToggleOpacity.setText("Toggle background");
        itemToggleOpacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemToggleOpacityActionPerformed(evt);
            }
        });
        jMenu2.add(itemToggleOpacity);

        itemToggleGrid.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        itemToggleGrid.setText("Toggle grid");
        itemToggleGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemToggleGridActionPerformed(evt);
            }
        });
        jMenu2.add(itemToggleGrid);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonChangeBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listRegions, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonWater)
                                    .addGap(10, 10, 10))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(buttonSteel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonBricks, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addComponent(selectedTile, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonGrass, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonIce, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonBricks)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonSteel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonWater))
                            .addComponent(selectedTile, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonIce)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonGrass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listRegions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonGenerate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonChangeBackground)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChangeBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeBackgroundActionPerformed
        JFileChooser chooser = new JFileChooser(lastPath);
        int opt = chooser.showOpenDialog(jPanel1);

        if (opt != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = chooser.getSelectedFile();

        if (file != null) {
            lastPath = new File(file.getPath());
            listRegions.setSelectedIndex(0);
            try {
                this.setTitle(file.getName());
                jPanel1.setName(file.getName());
                Image img = ImageIO.read(file);
                background = img;
                toggleBackground = false;
                clearLevel();
                repaintLater();
            } catch (IOException ex) {
                Logger.getLogger(EditorUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_buttonChangeBackgroundActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        generateLevelData();
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void itemClearLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClearLevelActionPerformed
        clearLevel();
        repaintLater();
    }//GEN-LAST:event_itemClearLevelActionPerformed

    private void itemToggleOpacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemToggleOpacityActionPerformed
        toggleBackground = !(toggleBackground);
        repaintLater();
    }//GEN-LAST:event_itemToggleOpacityActionPerformed

    private void buttonGrassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGrassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGrassActionPerformed

    private void itemToggleGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemToggleGridActionPerformed
        toggleGrid = !(toggleGrid);
        repaintLater();
    }//GEN-LAST:event_itemToggleGridActionPerformed

    private void listRegionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listRegionsActionPerformed
        switch (selectedType) {
            case AIR:
            case ICE:
            case TREES:
            case WATER: {
                listRegions.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_listRegionsActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditorUI instance = new EditorUI();
                SwingUtilities.updateComponentTreeUI(instance);
                instance.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton buttonBricks;
    private javax.swing.JButton buttonChangeBackground;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JRadioButton buttonGrass;
    private javax.swing.JRadioButton buttonIce;
    private javax.swing.JRadioButton buttonSteel;
    private javax.swing.JRadioButton buttonWater;
    private javax.swing.JMenuItem itemClearLevel;
    private javax.swing.JMenuItem itemToggleGrid;
    private javax.swing.JMenuItem itemToggleOpacity;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.Box.Filler jPanel1;
    private javax.swing.JComboBox<String> listRegions;
    private javax.swing.JButton selectedTile;
    // End of variables declaration//GEN-END:variables

    private final ActionListener buttonGroup1Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonName = getSelectedButton();
            setSelectedIcon(buttonName);

            switch (selectedType) {
                case AIR:
                case ICE:
                case TREES:
                case WATER: {
                    listRegions.setSelectedIndex(0);
                }
            }
        }
    };

    private void clearLevel() {
        for (Tile t : tiles) {
            t.setTexture("");
            t.type = Tile.Type.AIR;
            t.regionType = Tile.RegionType.FULL;
        }
        System.out.println("All tiles cleared!");
    }

    private String getSelectedButton() {
        Enumeration<AbstractButton> enumeration = buttonGroup1.getElements();

        while (enumeration.hasMoreElements()) {
            AbstractButton b = enumeration.nextElement();

            if (b.isSelected()) {
                return b.getText().toLowerCase();
            };
        }

        return null;
    }

    private void setSelectedIcon(String name) {
        switch (name) {
            case "bricks": {
                selectedTile.setIcon(BRICKS);
                selectedType = Tile.Type.BRICKS;
                break;
            }
            case "wall": {
                selectedTile.setIcon(WALL);
                selectedType = Tile.Type.WALL;
                break;
            }
            case "trees": {
                selectedTile.setIcon(TREES);
                selectedType = Tile.Type.TREES;
                break;
            }
            case "ice": {
                selectedTile.setIcon(ICE);
                selectedType = Tile.Type.ICE;
                break;
            }
            case "water": {
                selectedTile.setIcon(WATER);
                selectedType = Tile.Type.WATER;
                break;
            }
        }
    }

    private void generateBounds() {
        int x = (int) jPanel1.getLocationOnScreen().x;
        int y = (int) jPanel1.getLocationOnScreen().y;
        int maxTiles = 169;

        int gridX = x;
        int gridY = y;

        for (int i = 0; i < maxTiles; i++) {
            Tile r = new Tile(gridX, gridY, "");
            tiles.add(r);

            if (gridX < (jPanel1.getWidth() - TILE_SIZE)) {
                gridX += TILE_SIZE;
            } else {
                gridX = x;
                gridY += TILE_SIZE;
            }
        }
    }

    public void generateLevelData() {
        String data = "String[][] tiles = new String[][]{\n{";

        int row = 0;
        int count = 0;

        for (Tile t : tiles) {

            switch (count) {
                case 148: {
                    data += "\"eW:SBR\"";
                    break;
                }
                case 149: {
                    data += "\"eW:HD\"";
                    break;
                }
                case 150: {
                    data += "\"eW:SBL\"";
                    break;
                }
                case 161: {
                    data += "\"eW:HR\"";
                    break;
                }
                case 162: {
                    data += "\"e:F\"";
                    break;
                }
                case 163: {
                    data += "\"eW:HL\"";
                    break;
                }
                default: {
                    data += String.format("\"%s:%s\"", t.type.id, t.regionType.id);
                    break;
                }
            }

            count++;

            if (row < 12) {
                data += ",";
                row++;
            } else {
                if (count >= tiles.size()) {
                    data += "}};";
                } else {
                    data += "},\n{";
                }

                row = 0;
            }
        }

        System.out.println(data);
        System.out.println("");
        System.out.println("Image: " + jPanel1.getName() + " Total tiles: " + count);
    }

    private void repaintLater() {
        SwingUtilities.invokeLater(() -> {
            repaint();
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (tiles.isEmpty()) {
            generateBounds();
            repaintLater();
            return;
        }

        int x1 = 13;
        int y1 = 57;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.BLACK);

        if (background != null && !toggleBackground) {
            g2d.drawImage(background, x1, y1, rootPane);
        } else {
            g2d.drawImage(baseBackground, x1, y1, rootPane);
        }

        for (Tile tile : tiles) {

            int tidx = tile.id;

            if (tidx >= 148 && tidx <= 150 || tidx >= 161 && tidx <= 163) {
                continue;
            }

            ImageIcon img = tile.texture;

            if (img != null) {
                int tileX = tile.x;
                int tileY = tile.y;
                int tileW = tile.width;
                int tileH = tile.height;

                g2d.drawImage(img.getImage(), tile.x, tile.y, tile.width, tile.height, rootPane);

                switch (tile.regionType) {
                    case HALF_DOWN: {
                        g2d.clearRect(tileX, tileY, tileW, tileH / 2);
                        break;
                    }
                    case HALF_UP: {;
                        g2d.clearRect(tileX, tileY + (tileH / 2), tileW, tileH / 2);
                        break;
                    }
                    case HALF_LEFT: {
                        g2d.clearRect(tileX + (tileW / 2), tileY, tileW / 2, tileH);
                        break;
                    }
                    case HALF_RIGHT: {
                        g2d.clearRect(tileX, tileY, tileW / 2, tileH);
                        break;
                    }
                    case SINGLE_BOTTOM_LEFT: {
                        g2d.clearRect(tileX, tileY, tileW, tileH / 2);
                        g2d.clearRect(tileX + (tileW / 2), tileY + (tileH / 2), tileW / 2, tileH / 2);
                        break;
                    }
                    case SINGLE_BOTTOM_RIGHT: {
                        g2d.clearRect(tileX, tileY, tileW, tileH / 2);
                        g2d.clearRect(tileX, tileY + (tileH / 2), tileW / 2, tileH / 2);
                        break;
                    }
                    case SINGLE_UPPER_LEFT: {
                        g2d.clearRect(tileX + (tileW / 2), tileY, tileW / 2, tileH / 2);
                        g2d.clearRect(tileX, tileY + (tileH / 2), tileW, tileH / 2);
                        break;
                    }
                    case SINGLE_UPPER_RIGHT: {
                        g2d.clearRect(tileX, tileY, tileW / 2, tileH / 2);
                        g2d.clearRect(tileX, tileY + (tileH / 2), tileW, tileH / 2);
                        break;
                    }
                }

                g2d.setColor(Color.YELLOW);
                g2d.drawRect(tile.x, tile.y, tile.width, tile.height);
            }

            if (toggleGrid) {
                g2d.setColor(Color.WHITE);
                g2d.drawRect(tile.x, tile.y, tile.width, tile.height);
            }
        }
    }

    private Tile.RegionType getRegionType(int option) {
        switch (option) {
            case 1: {
                return Tile.RegionType.HALF_UP;
            }
            case 2: {
                return Tile.RegionType.HALF_DOWN;
            }
            case 3: {
                return Tile.RegionType.HALF_LEFT;
            }
            case 4: {
                return Tile.RegionType.HALF_RIGHT;
            }
            case 5: {
                return Tile.RegionType.SINGLE_UPPER_LEFT;
            }
            case 6: {
                return Tile.RegionType.SINGLE_BOTTOM_LEFT;
            }
            case 7: {
                return Tile.RegionType.SINGLE_UPPER_RIGHT;
            }
            case 8: {
                return Tile.RegionType.SINGLE_BOTTOM_RIGHT;
            }
            default: {
                return Tile.RegionType.FULL;
            }
        }
    }

    private boolean shiftPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getExtendedKeyCode() == KeyEvent.VK_SHIFT) {
            shiftPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getExtendedKeyCode() == KeyEvent.VK_SHIFT) {
            shiftPressed = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Tile t : tiles) {
            if (t.contains(e.getPoint())) {

                int tidx = t.id;

                System.out.println("Tile id: " + tidx);
                if (tidx >= 148 && tidx <= 150 || tidx >= 161 && tidx <= 163) {
                    continue;
                }

                if (e.getButton() == MouseEvent.BUTTON1) {
                    String texture = getSelectedButton();
                    t.setTexture(texture);
                    t.type = selectedType;
                    t.regionType = getRegionType(listRegions.getSelectedIndex());
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    t.setTexture("");
                    t.type = Tile.Type.AIR;
                    t.regionType = Tile.RegionType.FULL;
                }
                repaintLater();
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        boolean away = e.getWheelRotation() > 0;

        if (away) {

            if (shiftPressed) {
                int i = listRegions.getSelectedIndex();

                if (i == 0) {
                    i = listRegions.getItemCount();
                }

                listRegions.setSelectedIndex(i);
                return;
            }

            String name = getSelectedButton();
            setSelectedIcon(name);

            switch (name) {
                case "bricks": {
                    buttonSteel.setSelected(true);
                    break;
                }
                case "wall": {
                    buttonWater.setSelected(true);
                    break;
                }
                case "water": {
                    buttonIce.setSelected(true);
                    break;
                }
                case "ice": {
                    buttonGrass.setSelected(true);
                    break;
                }
                case "trees": {
                    buttonBricks.setSelected(true);
                    break;
                }
            }
        } else {

            if (shiftPressed) {
                int i = listRegions.getSelectedIndex();

                if (i == listRegions.getItemCount()) {
                    i = 0;
                }

                listRegions.setSelectedIndex(i);
                return;
            }

            String name = getSelectedButton();
            setSelectedIcon(name);

            switch (name) {
                case "bricks": {
                    buttonGrass.setSelected(true);
                    break;
                }
                case "wall": {
                    buttonBricks.setSelected(true);
                    break;
                }
                case "water": {
                    buttonSteel.setSelected(true);
                    break;
                }
                case "ice": {
                    buttonWater.setSelected(true);
                    break;
                }
                case "trees": {
                    buttonIce.setSelected(true);
                    break;
                }
            }
        }
    }
}
