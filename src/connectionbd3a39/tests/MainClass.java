/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionbd3a39.tests;

import connectionbd3a39.tools.DataSource;

/**
 *
 * @author GAMERS
 */
public class MainClass {
    public static void main(String[] args) {
        DataSource.getInstance();
        TestAnnonce tAnnonce = new TestAnnonce();

    }
}
