/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.api;

/**
 *
 * @author bernd_000
 */
public interface PhysioManagerClientIF {
    public boolean checkPassword(String username, char[] password);
}
