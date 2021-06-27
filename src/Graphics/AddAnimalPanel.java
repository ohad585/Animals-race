/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Graphics;

import Animals.*;
import Olympics.Medal;
import Mobility.Point;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.spi.NumberFormatProvider;
import java.util.InputMismatchException;
import java.util.Vector;

/**
 * Sub panel to add animals
 */
public class AddAnimalPanel  extends JPanel implements ActionListener , DocumentListener {
    protected JLabel typeLabel;
    protected JComboBox typeComboBox;
    protected JLabel animalLabel;
    protected JComboBox animalComboBox;
    protected JComboBox pictureComboBox;
    protected JLabel picture;
    protected JLabel nameLabel;
    protected JLabel genderLabel;
    protected JLabel weiLabel;
    protected JLabel speLabel;
    protected JLabel energyLabel;
    protected JLabel EPMLabel;
    protected JLabel label_for_type;
    protected JLabel label_for_animal;
    protected JLabel extra_snake;
    protected JTextField nameTextField;
    protected JComboBox genderComboBox;
    protected JTextField weiTextField;
    protected JTextField speTextField;
    protected JTextField energyTextField;
    protected JTextField EPMTextField;
    protected JTextField text_for_type;
    protected JTextField text_for_animal;
    protected JTextField text_extra_snake;
    protected JButton createBtn;

    private String[] land = {"Cat","Dog","Snake"};
    private String[] air = {"Pigeon","Eagle"};
    private String[] water = {"Dolphin","Whale","Alligator"};
    private String[] genders = {"Male","Female","Hermaphrodite"};

    private CompetitionType competitionType;
    private int maxEnergy,energyPetMet,nologs,waterextra;
    private String name,s_animal_extra;
    private genderType gndr;
    private double weight,speed,air_water_extra,d_animal_extra;
    private Animal animal;
    private boolean castr,snakeflag;
    private PoisonousLevel poisonousLevel;
    private Vector<Animal> animals;
    private static final int MAXANIMALS=5;

    /**
     * Constructor .
     * @param type the competition type.
     */
    public AddAnimalPanel(CompetitionType type){
        this.animals=new Vector<Animal>();
        competitionType=type;

        setLayout(new GridLayout(0,2));
        setSize(200,300);
        typeLabel=new JLabel("Type");
        animalLabel=new JLabel("Animal");
        setAnimalComboBox(type);
        nameLabel=new JLabel("Name");
        nameTextField=new JTextField();
        genderLabel=new JLabel("Gender");
        genderComboBox=new JComboBox(genders);
        weiLabel=new JLabel("Weight");
        weiTextField=new JTextField();
        speLabel=new JLabel("Speed");
        speTextField=new JTextField();
        energyLabel=new JLabel("Energy");
        energyTextField=new JTextField();
        EPMLabel=new JLabel("Energy per meter");
        EPMTextField=new JTextField();
        extra_snake=new JLabel("Length");
        label_for_type=new JLabel();
        label_for_animal=new JLabel();
        text_extra_snake=new JTextField();
        text_for_animal=new JTextField();
        text_for_type=new JTextField();
        createBtn=new JButton("Create");
        createBtn.setEnabled(false);

        animalComboBox.addActionListener(this);
        createBtn.addActionListener(this);
        text_for_animal.getDocument().addDocumentListener(this);

        add(typeLabel);
        add(new JLabel(type.toString()));
        add(animalLabel);
        add(animalComboBox);
        add(nameLabel);
        add(nameTextField);
        add(genderLabel);
        add(genderComboBox);
        add(weiLabel);
        add(weiTextField);
        add(speLabel);
        add(speTextField);
        add(energyLabel);
        add(energyTextField);
        add(EPMLabel);
        add(EPMTextField);
        firstinit(type.toString());
        add(label_for_type);
        add(text_for_type);
        add(label_for_animal);
        add(text_for_animal);
        add(createBtn);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==typeComboBox){
            int temp=typeComboBox.getSelectedIndex();
            switch (temp){
                case 0:
                    animalComboBox.setModel(new DefaultComboBoxModel(air));

                    break;
                case 1:
                    animalComboBox.setModel(new DefaultComboBoxModel(water));
                    break;
                case 2:
                    animalComboBox.setModel(new DefaultComboBoxModel(land));
                    break;
            }
        }
        if(e.getSource()==createBtn){
            name=nameTextField.getText();
            int temp=genderComboBox.getSelectedIndex();
            switch (temp){
                case 0:
                    gndr=genderType.Male;
                    break;
                case 1:
                    gndr=genderType.Female;
                    break;
                case 2:
                    gndr=genderType.Hermaphrodite;
                    break;
            }
            try {
                weight = Double.parseDouble(weiTextField.getText());
                speed = Double.parseDouble(speTextField.getText());
                maxEnergy = Integer.parseInt(energyTextField.getText());
                energyPetMet = Integer.parseInt(EPMTextField.getText());

                if (name == null || weight == 0 || speed == 0) {
                    JOptionPane.showMessageDialog(this, "Error ,check parameters");
                    //insert try again
                }
                String flagType = competitionType.toString();
                int flagAnimal = animalComboBox.getSelectedIndex();
                switch (flagType) {
                    case "Air":
                        air_water_extra = Double.parseDouble(text_for_type.getText());
                        switch (flagAnimal) {
                            case 0:
                                s_animal_extra = text_for_animal.getText();
                                animal = new Pigeon(name, gndr, weight, speed, new Medal[0], null, air_water_extra, s_animal_extra, maxEnergy, energyPetMet);
                                System.out.println("Pigeon Created");
                                break;
                            case 1:
                                d_animal_extra = Double.parseDouble(text_for_animal.getText());
                                animal = new Eagle(name, gndr, weight, speed, new Medal[0], null, air_water_extra, d_animal_extra, maxEnergy, energyPetMet);
                                System.out.println("Eagle Created");
                                break;
                        }
                        break;
                    case "Water":
                        waterextra = Integer.parseInt(text_for_type.getText());
                        switch (flagAnimal) {
                            case 0:
                                nologs = Integer.parseInt(text_for_animal.getText());
                                animal = new Dolphin(name, gndr, weight, speed, new Medal[0], null, waterextra, nologs, maxEnergy, energyPetMet);
                                System.out.println("Dolphin Created");
                                break;
                            case 1:
                                s_animal_extra = text_for_animal.getText();
                                animal = new Whale(name, gndr, weight, speed, new Medal[0], null, waterextra, s_animal_extra, maxEnergy, energyPetMet);
                                System.out.println("Whale Created");
                                break;
                            case 2:
                                s_animal_extra = text_for_animal.getText();
                                animal = new Alligator(name, gndr, weight, speed, new Medal[0], null, waterextra, s_animal_extra, 4, maxEnergy, energyPetMet);
                                System.out.println("Water alligator Created");
                                break;
                        }
                        break;
                    case "Terrestrial":
                        nologs = Integer.parseInt(text_for_type.getText());
                        switch (flagAnimal) {
                            case 0:
                                switch (text_for_animal.getText().toUpperCase()) {
                                    case "Y":
                                        castr = true;
                                        break;
                                    default:
                                        castr = false;
                                        break;
                                }
                                animal = new Cat(name, gndr, weight, speed, new Medal[0], null, nologs, castr, maxEnergy, energyPetMet);
                                System.out.println("Cat Created");
                                break;
                            case 1:
                                s_animal_extra = text_for_animal.getText();
                                animal = new Dog(name, gndr, weight, speed, new Medal[0], null, nologs, s_animal_extra, maxEnergy, energyPetMet);
                                System.out.println("Dog Created");
                                break;
                            case 2:
                                switch (text_for_animal.getText()) {
                                    case "H":
                                        poisonousLevel = PoisonousLevel.HIGH;
                                        break;
                                    case "M":
                                        poisonousLevel = PoisonousLevel.MEDIUM;
                                        break;
                                    default:
                                        poisonousLevel = PoisonousLevel.LOW;
                                        break;
                                }
                                d_animal_extra = Double.parseDouble(text_extra_snake.getText());
                                animal = new Snake(name, gndr, weight, speed, new Medal[0], null, poisonousLevel, d_animal_extra, maxEnergy, energyPetMet);
                                System.out.println("Snake Created");
                                break;
                            case 3:
                                animal = new Alligator(name, gndr, weight, speed, new Medal[0], null, 3, "Swamp", 4, maxEnergy, energyPetMet);
                                System.out.println("Land alligator Created");
                                break;
                        }
                        break;
                }
            //animals.add(animal);
            AnimalPicture panel=new AnimalPicture(animal.retType().toLowerCase(),animal.picArsenal());
            int result = JOptionPane.showConfirmDialog(this, panel, "Choose picture", JOptionPane.OK_CANCEL_OPTION);
            if(result==JOptionPane.OK_OPTION){
                animal.setPicnumber(panel.retSelected());
            }
            animals.addElement(animal);
            }catch (Exception z){
                JOptionPane.showMessageDialog(this,"Bad Parameters!!\nTry Again!");
                JComponent jComponent=(JComponent)e.getSource();
                Window win=SwingUtilities.getWindowAncestor(jComponent);
                win.dispose();
            }
        }
        if(e.getSource()==animalComboBox){
            switch (competitionType.toString()) {
                case "Terrestrial":
                update_gui(competitionType.toString(), land[animalComboBox.getSelectedIndex()]);
                break;
                case "Water":
                    update_gui(competitionType.toString(), water[animalComboBox.getSelectedIndex()]);
                    break;
                case "Air":
                    update_gui(competitionType.toString(), air[animalComboBox.getSelectedIndex()]);
                    break;
            }
        }
    }

    /**
     * Recives competition type and sets the animal JComboBox accordingly .
     * @param competitionType competition type received.
     */
    public void setAnimalComboBox(CompetitionType competitionType) {
        switch (competitionType){
            case Air:
                animalComboBox=new JComboBox(air);
                break;
            case Water:
                animalComboBox=new JComboBox(water);
                break;
            case Terrestrial:
                animalComboBox=new JComboBox(land);
                break;
        }
    }

    /**
     * Update the GUI to the relevant animal fields.
     * @param type competition type as string.
     * @param animal the animal selected at the combobox as a string.
     */
    public void update_gui(String type,String animal){
        switch (type){
            case "Air":
                label_for_type.setText("Wing span");
                switch (animal){
                    case "Pigeon":

                        label_for_animal.setText("Famliy");
                        break;
                    case "Eagle":
                        label_for_animal.setText("Altitude");
                        break;
                }
                break;
            case "Water":
                label_for_type.setText("Depth");
                switch (animal){
                    case "Dolphin":
                        label_for_animal.setText("Water type(1-sea,2-sweet)");
                        break;
                    case "Whale":
                        label_for_animal.setText("Food type");
                        break;
                    case "Alligator":
                        label_for_animal.setText("Area of living");
                        break;
                }
                break;
            case "Terrestrial":
                if(snakeflag){
                    remove(extra_snake);
                    remove(text_extra_snake);
                    snakeflag=false;
                }
                label_for_type.setText("Legs number");
                switch (animal){
                    case "Cat":
                        label_for_animal.setText("Castrated(Y/N)");
                        break;
                    case "Dog":
                        label_for_animal.setText("Breed");
                        break;
                    case  "Snake":
                        snakeflag=true;
                        label_for_animal.setText("Poisonous level(H,M,L)");
                        remove(createBtn);
                        add(extra_snake);
                        add(text_extra_snake);
                        add(createBtn);

                        break;
                }
                break;
            default:
                System.out.println("Bad Parameters");
                break;
        }
    }

    /**
     * override the JPanel setSize .
     * @param w width.
     * @param h height.
     */
    public final void setSize(int w, int h) {
        setPreferredSize(new Dimension(w, h));
        Container c = this.getTopLevelAncestor();
        if (c instanceof JFrame) {
            JFrame f = (JFrame) c;
            f.pack();
        }
    }

    /**
     * sets the animal JLabel accordingly the the animal JComboBox on the first run.
     * @param type competition type as String.
     */
    private void firstinit(String type){
        switch (type){
            case "Terrestrial":
                update_gui(type,"Cat");
                break;
            case "Water":
                update_gui(type,"Dolphin");
                break;
            default:
                update_gui(type,"Pigeon");
        }
    }

    /**
     * gets called from a higher frame to return animals created on this panel.
     * @return All animals created.
     */
    public Vector<Animal> retCreated(){return  animals;};

    /**
     * Gives notification that there was an insert into the document.  The
     * range given by the DocumentEvent bounds the freshly inserted region.
     *
     * @param e the document event
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        if(!(weiTextField.getText().equals("") || speTextField.getText().equals("") ||
                energyTextField.getText().equals("") || EPMTextField.getText().equals("") ||
                text_for_type.getText().equals("") || text_for_animal.getText().equals(""))) {
            createBtn.setEnabled(true);

        }
    }

    /**
     * Gives notification that a portion of the document has been
     * removed.  The range is given in terms of what the view last
     * saw (that is, before updating sticky positions).
     *
     * @param e the document event
     */
    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    /**
     * Gives notification that an attribute or set of attributes changed.
     *
     * @param e the document event
     */
    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
