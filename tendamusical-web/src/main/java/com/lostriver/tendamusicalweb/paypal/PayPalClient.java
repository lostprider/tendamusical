package com.lostriver.tendamusicalweb.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
/**
 * 
 * @author DevPredator
 * Clase Client de PayPal que configura las clases necesarias para realizar las transacciones 
 * hacia PayPal y tambien el CLIENT ID y SECRET ID de acceso a la aplicacion de Sandbox.
 */
public class PayPalClient {

  /**
   *Set up the PayPal Java SDK environment with PayPal access credentials.  
   *This sample uses SandboxEnvironment. In production, use LiveEnvironment.
   */
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
    "AfpXrzVEWDTrBYuG0ANo-TwhSJqmOXz8uaSWVkYVO3tzq4DaNn5EaDDsPimua6oSbWMc2t4z5lbgo4bz",
    "EFPJGHv60SFgSwppsoeLK2SVc85xqu1vwzpdx0Om_cI6aZWkwOR3_etco-i1d52GOvFH3MZqZEuE00fN");

  /**
   *PayPal HTTP client instance with environment that has access
   *credentials context. Use to invoke PayPal APIs.
   */
  PayPalHttpClient client = new PayPalHttpClient(environment);

  /**
   *Method to get client object
   *
   *@return PayPalHttpClient client
   */
  public PayPalHttpClient client() {
    return this.client;
  }
}
