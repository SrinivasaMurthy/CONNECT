/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.hhs.fha.nhinc.docquery.adapter.deferred.request.error;

import gov.hhs.fha.nhinc.async.AsyncMessageIdExtractor;
import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.saml.extraction.SamlTokenExtractor;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author jhoppesc
 */
@WebService(serviceName = "AdapterDocQueryDeferredRequestErrorSecured", portName = "AdapterDocQueryDeferredRequestErrorSecuredPortSoap", endpointInterface = "gov.hhs.fha.nhinc.adapterdocquerydeferredrequesterrorsecured.AdapterDocQueryDeferredRequestErrorSecuredPortType", targetNamespace = "urn:gov:hhs:fha:nhinc:adapterdocquerydeferredrequesterrorsecured", wsdlLocation = "WEB-INF/wsdl/AdapterDocQueryDeferredRequestErrorSecured/AdapterDocQueryDeferredRequestErrorSecured.wsdl")
@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class AdapterDocQueryDeferredRequestErrorSecured {
    @Resource
    private WebServiceContext context;

    public gov.hhs.healthit.nhin.DocQueryAcknowledgementType respondingGatewayCrossGatewayQuery(gov.hhs.fha.nhinc.common.nhinccommonadapter.AdapterDocumentQueryDeferredRequestErrorSecuredType body) {
        return new AdapterDocQueryDeferredRequestErrorSecuredImpl().respondingGatewayCrossGatewayQuery(body, context);
    }

}