/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentelistatareas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author julian
 */
public class IntentoC1 extends JPanel {
    private JLabel titleLabel;
    private JPanel taskContainer;
    private ArrayList<JCheckBox> taskList;
    private JButton borrarButton, aniadirButton;
    private javax.swing.JTextPane jTextPane1;

    public IntentoC1(String title) {
        setLayout(new BorderLayout());
        
        Border border = new LineBorder(new Color(0,170,228), 5); // Borde color y grosor
        setBorder(border);
        
// Título
        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        // Contenedor para las tareas (CheckBoxes)
        taskContainer = new JPanel();
        taskContainer.setLayout(new BoxLayout(taskContainer, BoxLayout.Y_AXIS));
        add(new JScrollPane(taskContainer), BorderLayout.CENTER);

        // Panel para botones
         JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));

        // Botón para eliminar tareas completadas
        borrarButton = new JButton("Eliminar tareas completadas");
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCompletedTasks();
            }
        });
        buttonPanel.add(borrarButton);
        
        
        
        // Botón para añadir tareas 
        aniadirButton = new JButton("Añadir tarea");
        aniadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            addNewTask(); 
            }
        });
        buttonPanel.add(aniadirButton);

        // Añadir el panel de botones al sur del panel principal
        add(buttonPanel, BorderLayout.SOUTH);


        taskList = new ArrayList<>();
    }

    //Metodo para añadir una tarea en el panel 
    private void addNewTask() {
        String taskName = JOptionPane.showInputDialog(this, "Ingrese el nombre de la nueva tarea:");
        if (taskName != null && !taskName.trim().isEmpty()) {
            addTask(taskName);
        }
    }
    // Método para agregar una nueva tarea (CheckBox)
    public void addTask(String taskName) {
        JCheckBox newTask = new JCheckBox(taskName);
        newTask.setSelected(false);  
        taskList.add(newTask);
        taskContainer.add(newTask);
        taskContainer.revalidate();  // Actualiza el panel
        taskContainer.repaint();
    }

    // Método para eliminar las tareas que están completadas (seleccionadas)
    private void deleteCompletedTasks() {
        for (int i = 0; i < taskList.size(); i++) {
            JCheckBox task = taskList.get(i);
            if (task.isSelected()) {
                taskContainer.remove(task);
                taskList.remove(task);
                i--; // Ajusta el índice después de eliminar
            }
        }
        taskContainer.revalidate();  // Actualiza el panel
        taskContainer.repaint();
    }
    public static void main(String[] args) {
    }
}
