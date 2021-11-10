package battlecitymapeditor;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author JH62
 */
public class Tile extends Rectangle {

    public ImageIcon texture = null;

    public final int SIZE = 16;

    public enum Type {
        AIR("x"),
        BRICKS("w"),
        WALL("s"),
        WATER("W"),
        ICE("i"),
        TREES("t");

        public final String id;

        Type(String id) {
            this.id = id;
        }
    }

    public enum RegionType {
        FULL("F"),
        HALF_LEFT("HL"),
        HALF_RIGHT("HR"),
        HALF_UP("HU"),
        HALF_DOWN("HD"),
        SINGLE_UPPER_LEFT("SUL"),
        SINGLE_UPPER_RIGHT("SUR"),
        SINGLE_BOTTOM_LEFT("SBL"),
        SINGLE_BOTTOM_RIGHT("SBR");

        public final String id;

        RegionType(String id) {
            this.id = id;
        }
    }

    public Type type = Type.AIR;
    public RegionType regionType = RegionType.FULL;
    public final int id;

    private static int tileCount = 0;

    public Tile(int x, int y, String name) {
        this(x, y, Type.AIR, RegionType.FULL, name);
    }

    public Tile(int x, int y, Type type, RegionType regionType, String name) {
        this.setBounds(x, y, SIZE, SIZE);
        this.setTexture(name);
        this.type = type;
        this.regionType = regionType;
        this.id = tileCount++;
    }

    public final void setTexture(String name) {
        switch (name) {
            case "bricks": {
                this.type = Type.BRICKS;
                texture = EditorUI.BRICKS;
                break;
            }
            case "wall": {
                this.type = Type.WALL;
                texture = EditorUI.WALL;
                break;
            }
            case "trees": {
                this.type = Type.TREES;
                texture = EditorUI.TREES;
                break;
            }
            case "ice": {
                this.type = Type.ICE;
                texture = EditorUI.ICE;
                break;
            }
            case "water": {
                this.type = Type.WATER;
                texture = EditorUI.WATER;
                break;
            }
            default: {
                this.type = Type.AIR;
                texture = null;
                break;
            }
        }
    }
}
