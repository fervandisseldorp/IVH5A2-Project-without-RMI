/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.main;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.control.LoginController;
import edu.avans.ivh5.client.view.ui.LoginScreen;
import edu.avans.ivh5.server.model.main.PhysioManagerImpl;

/**
 *
 * @author bernd_000
 */
public class PhysioClient {
    public static void main(String[] args) {
        PhysioManagerClientIF manager = (PhysioManagerClientIF) new PhysioManagerImpl();
        LoginController controller = new LoginController(manager);
        new LoginScreen(controller);
    }
}
