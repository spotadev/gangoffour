/*
    =======================================================================================
    This code is part of SpotADev.

    SpotADev is e-commerce software for East Africa. SpotADev is a design from JavaSpeak.
    JavaSpeak is a name given to a collective of developers managed by John Dickerson.
    
    The following were the licensors of SpotADev at the time this file was 
    created / last edited:
    
    John Dickerson, Ronald Kasaija, Joel Mumo, Stephen Juma, Stephen Mwanzi, Jackline Gitari, 
    Samuel Kisilu, Nixon Chebii, Mercy Chepkoech
    
    The individual voting rights / control / share of profits to the individual developers 
    is roughly proportional to their contribution.
    
    Additional Licensors may be added to this license if the licensors agree to it based
    on their voting rights.   In the case that a contributor is to work on the project
    and not be a licensor they need to sign a waiver that they understand they do not
    have voting rights, control or a share of profits.  This waiver remains in force
    until the current licensors agree to add the licensor to this license as a licensor.
    
    The SpotADev software has a proprietary license. Please look at or request
    spotadev_license.txt for further details.

    Copyright (C) 2019 JavaSpeak

    Email:  john.charles.dickerson@gmail.com

    ========================================================================================
    Author : John Dickerson
    ========================================================================================
*/
package com.javaspeak.designpatterns.go4.behavioural.memento;

/**
 * This class describes document editing functionality such as saving the document text, font 
 * family and font size.
 * <p>
 * This interface extends the Originator interface which has additional methods like:
 * <pre>
 * {@code
 * public Memento getMemento();
 * public void restoreFromMemento( Memento memento );
 * }
 * </pre>
 * The Document interface is implemented by the Originator.  When the getMemento() method is called 
 * on the Document the Document returns a snapshot of its state in a DocumentMemento object.
 * <p>
 * When the restoreFromMemento(..) is called on the Document the Document will roll back its state 
 * to the state encapsulated in the DocumentMemento object.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class DocumentImpl implements Document {

    private String documentText;
    private String fontFamily;
    private int fontSize;

    /**
     * Inner class used to create a Memento saving the current state of the document text.  Note 
     * that the final DocumentMemento has a private constructor and no setters so its state cannot 
     * be modified after it has been created.
     */
    final class DocumentMemento implements Memento {

        final private String documentMemento;

        private DocumentMemento( String document ) {

            documentMemento = new String( document );
        }


        private String getDocumentText() {

            return documentMemento;
        }
    }

    // START Document interface methods ============================================================

    @Override
    public void saveDocumentText( String documentText ) {

        this.documentText = documentText;
    }


    @Override
    public String getDocumentText() {

        return this.documentText;
    }


    @Override
    public void saveFontFamily( String fontFamily ) {

        this.fontFamily = fontFamily;
    }


    @Override
    public String getFontFamily() {

        return fontFamily;
    }


    @Override
    public void saveFontSize( int fontSize ) {

        this.fontSize = fontSize;
    }


    @Override
    public int getFontSize() {

        return fontSize;
    }

    // END Document interface methods ==============================================================

    // START Caretaker interface methods ===========================================================

    @Override
    public Memento getMemento() {

        return new DocumentMemento( documentText );
    }


    @Override
    public void restoreFromMemento( Memento memento ) {

        DocumentMemento documentMemento = ( DocumentMemento )memento;
        this.documentText = documentMemento.getDocumentText();
    }

    // END Caretaker interface methods =============================================================
}
