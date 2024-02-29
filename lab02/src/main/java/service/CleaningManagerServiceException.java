/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package service;

/**
 *
 * @author gurra
 */
public class CleaningManagerServiceException extends RuntimeException {

    /**
     * Creates a new instance of <code>CleaningManagerServiceException</code>
     * without detail message.
     */
    public CleaningManagerServiceException() {
    }

    /**
     * Constructs an instance of <code>CleaningManagerServiceException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CleaningManagerServiceException(String msg) {
        super(msg);
    }
    public CleaningManagerServiceException(String msg, Throwable cause) {
        super(msg);
    }

    public CleaningManagerServiceException(Throwable cause) {
        super(cause);
    }
    
    
}
