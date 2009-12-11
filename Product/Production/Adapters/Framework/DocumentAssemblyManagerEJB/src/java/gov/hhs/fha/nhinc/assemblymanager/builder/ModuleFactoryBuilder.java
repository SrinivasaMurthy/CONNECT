/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.hhs.fha.nhinc.assemblymanager.builder;

import gov.hhs.fha.nhinc.assemblymanager.builder.cda.modules.CDAModule;
import gov.hhs.fha.nhinc.assemblymanager.builder.cda.modules.MedicationModule;
import gov.hhs.fha.nhinc.assemblymanager.builder.cda.modules.AllergiesModule;
import gov.hhs.fha.nhinc.assemblymanager.builder.cda.modules.ProblemsModule;
import gov.hhs.fha.nhinc.template.TemplateConstants;
import gov.hhs.fha.nhinc.template.model.CdaTemplate;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hl7.v3.CareRecordQUPCIN043200UV01ResponseType;
import org.hl7.v3.POCDMT000040Entry;

/**
 *
 * @author kim
 */
public class ModuleFactoryBuilder {

   private static Log log = LogFactory.getLog(ModuleFactoryBuilder.class);

   /**
    * Returns a list of entries representing the requested clinical domain in the template.
    *
    * @param template template information
    * @param careRecord domain clinical information
    * @return
    */
   public final static List<POCDMT000040Entry> createModule(CdaTemplate template, CareRecordQUPCIN043200UV01ResponseType careRecord) {
      String hitspTemplateId = template.getHitspTemplateId();
      CDAModule moduleBuilder = null;

      try {
         // medication module
         if (hitspTemplateId.equalsIgnoreCase(TemplateConstants.MEDICATION_MODULE_HITSP_TEMPLATE_ID)) {
            moduleBuilder = new MedicationModule(template, careRecord);
         } // condition module
         else if (hitspTemplateId.equalsIgnoreCase(TemplateConstants.CONDITION_MODULE_HITSP_TEMPLATE_ID)) {
              moduleBuilder = new ProblemsModule(template, careRecord);
         }
         // allergy module
         else if (hitspTemplateId.equalsIgnoreCase(TemplateConstants.ALLERGY_MODULE_HITSP_TEMPLATE_ID)) {
            moduleBuilder = new AllergiesModule(template, careRecord);
         }
         else {
            log.error("Template: \"" + hitspTemplateId + "\" - Not implemented yet.");
            return new ArrayList<POCDMT000040Entry>();
         }

         return moduleBuilder.build();
      } catch (DocumentBuilderException ex) {
         log.error("Failed to build template section \"" + hitspTemplateId + "\".", ex);
         return new ArrayList<POCDMT000040Entry>();
      }
   }
}
