package Castom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicPasswordFieldUI;


public class JpasswordCustom extends JPasswordField{
    
    private PasswordFieldUI textUI;
    
    
    public JpasswordCustom() {
        textUI = new PasswordFieldUI(this);
        setUI(textUI);
    }
    
    private class PasswordFieldUI extends BasicPasswordFieldUI{
        
        private JPasswordField passwordField;
        private Border border;
        private int round = 15;
        private List<String> items = new ArrayList<>();

        public Border getBorder() {
            return border;
        }

        public void setBorder(Border border) {
            this.border = border;
        }

        public int getRound() {
            return round;
        }

        public void setRound(int round) {
            this.round = round;
        }

        public List<String> getItems() {
            return items;
        }

        public void setItems(List<String> items) {
            this.items = items;
        }
        
        public PasswordFieldUI(JPasswordField passwordField) {
            this.passwordField = passwordField;
            border = new Border (10);
            border.setRound(round);
            passwordField.setBorder(border);
            passwordField.setOpaque(false);
            passwordField.setSelectedTextColor(Color.WHITE);
            passwordField.setSelectionColor(new Color(52,189,248));
            passwordField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent fe) {
                    border.setColor(new Color(128,189,255));
                    passwordField.repaint();
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    border.setColor(new Color(206,212,218));
                    passwordField.repaint();
                }
             
            });
        }

        @Override
        protected void paintBackground(Graphics grphcs) {
            if(passwordField.isOpaque()){
                Graphics2D g2 = (Graphics2D) grphcs.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(passwordField.getBackground());
                g2.fillRoundRect(0, 0, passwordField.getWidth(), passwordField.getHeight(), round, round);
                g2.dispose();
            }
        }
        
        private class Border extends EmptyBorder{
           
            private Color focusColor = new Color(128,189,255);
            private Color color = new Color(206,212,218);
            private int round;

            public Color getFocusColor() {
                return focusColor;
            }

            public void setFocusColor(Color focusColor) {
                this.focusColor = focusColor;
            }

            public Color getColor() {
                return color;
            }

            public void setColor(Color color) {
                this.color = color;
            }

            public int getRound() {
                return round;
            }

            public void setRound(int round) {
                this.round = round;
            }
                    
            
            
            
            public Border(int border) {
                super(border,border,border,border);
            }
            
           public Border(){
               this (5);
           } 

            @Override
            public void paintBorder(Component cmpnt, Graphics grphcs, int i, int i1, int i2, int i3) {
                Graphics2D g2 = (Graphics2D) grphcs.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if(cmpnt.isFocusOwner()){
                    g2.setColor(focusColor);
                }else{
                    g2.setColor(color);
                }
                g2.drawRoundRect(i, i1, i2 -1 , i3 -1, round, round);
                g2.dispose();
            }
            
           
        }
    }
}
