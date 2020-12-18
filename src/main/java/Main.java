import org.openbabel.*;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.SDFWriter;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

   public static void main(String[] args) {
        try {
            SmilesParser sp = new SmilesParser(SilentChemObjectBuilder.getInstance());
            IAtomContainer m = sp.parseSmiles("C(Cl)(=O)CCC(=O)Cl");

            try {
                File sdfFile = new File("sdfFile.sdf");
                sdfFile.createNewFile();

                FileWriter sdfFileWriter = new FileWriter("sdfFile.sdf");
                SDFWriter sdfWriter = new SDFWriter(sdfFileWriter);
                try {
                    sdfWriter.write(m);
                } catch (CDKException e) {
                    System.out.println(e.getMessage());
                } finally {
                    sdfWriter.close();
                    sdfFileWriter.close();
                }

            } catch (IOException e) {

            }

            System.out.println("Valid Smiles.");
        } catch (InvalidSmilesException e) {
            System.out.println("Invalid Smiles Exception.");
        }
   }
}
