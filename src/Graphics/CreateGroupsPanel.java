/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Graphics;

import Animals.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class CreateGroupsPanel extends JPanel implements ActionListener {

    private JPanel panel1;
    private JPanel panel2;
    private JButton[] addBtns;
    private JLabel[] teamNamesLabels;
    private JList[] jLists;
    private ButtonGroup buttonGroup;
    private JRadioButton courierRadioBtn;
    private JRadioButton regularRadioBtn;
    private DefaultListModel[] stringForJlists;
    private JScrollPane[] verticals;

    private Vector<Animal>[] animals;
    private int numberOfGroups;
    private CompetitionType compType;

    public CreateGroupsPanel(int numberOfGroups,CompetitionType compType,Animal[][] animals){
        //setSize(300,800);
        this.numberOfGroups=numberOfGroups;
        this.compType=compType;
        this.animals = new Vector[numberOfGroups];
        addBtns=new JButton[numberOfGroups];
        jLists=new JList[numberOfGroups];
        teamNamesLabels=new JLabel[numberOfGroups];
        stringForJlists=new DefaultListModel[numberOfGroups];
        verticals=new JScrollPane[numberOfGroups];

        for(int i=0;i<numberOfGroups;i++){
                this.animals[i]=new Vector<Animal>();
                stringForJlists[i] = new DefaultListModel<String>();
        }
        if(animals!=null){
            for(int i=0;i<animals.length;i++) {
                this.animals[i].addAll(Arrays.asList(animals[i]));
                stringForJlists[i].addAll(Arrays.asList(animals[i]));
            }

            }
        setLayout(new BorderLayout());


        panel1=new JPanel();//new GridLayout(1,2));
        panel2=new JPanel(new GridLayout(3,numberOfGroups));
        buttonGroup=new ButtonGroup();
        regularRadioBtn=new JRadioButton("Regular Tournament");
        regularRadioBtn.setSelected(true);
        courierRadioBtn=new JRadioButton("Courier Tournament");
        buttonGroup.add(regularRadioBtn);
        buttonGroup.add(courierRadioBtn);

        panel2.setPreferredSize(new Dimension(100*numberOfGroups,200));

        add(panel1,BorderLayout.NORTH);
        add(panel2,BorderLayout.SOUTH);
        panel1.add(regularRadioBtn);
        panel1.add(courierRadioBtn);
        for(int i =0;i<numberOfGroups;i++){
            teamNamesLabels[i]=new JLabel("     Team "+i);
            panel2.add(teamNamesLabels[i]);
        }
        for(int i =0;i<numberOfGroups;i++){
            addBtns[i]=new JButton("Add animal");
            addBtns[i].addActionListener(this);
            panel2.add(addBtns[i]);
        }
        for(int i =0;i<numberOfGroups;i++){
            jLists[i]=new JList(stringForJlists[i]);
            verticals[i]=new JScrollPane(jLists[i]);
            panel2.add(verticals[i]);
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int btnNumber=-1;
        for(int i =0;i<numberOfGroups;i++){
            if(e.getSource()==addBtns[i]){
                btnNumber=i;
            }
        }
        if(btnNumber!=-1){
            AddAnimalPanel panel = new AddAnimalPanel(this.compType);
            int result = JOptionPane.showConfirmDialog(this, panel, "Add Animal", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                animals[btnNumber].addAll(panel.retCreated());
                stringForJlists[btnNumber].removeAllElements();
                for (int i = 0; i < animals[btnNumber].size(); i++) {
                    stringForJlists[btnNumber].addElement(animals[btnNumber].get(i));
                }
                if(animals[btnNumber].size()>=2){
                    regularRadioBtn.setEnabled(false);
                    courierRadioBtn.setSelected(true);
                }
                repaint();
                revalidate();
            }
        }
    }

    public int getTournamentType(){
        if(courierRadioBtn.isSelected())
            return 1;
        else return 0;
    }

    public Animal[][] getAnimals() {
        Animal[][] temp=new Animal[numberOfGroups][];
        for(int i=0;i<numberOfGroups;i++){
            temp[i]=new Animal[animals[i].size()];
            for(int j=0;j<animals[i].size();j++){
                temp[i][j]=animals[i].get(j);
            }
        }
        return temp;
    }
}
