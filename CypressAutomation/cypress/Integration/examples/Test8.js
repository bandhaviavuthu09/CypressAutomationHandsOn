/// <reference types="Cypress" />
/// <reference types="Cypress-iframe" />
 
import 'cypress-iframe'

describe('Frames Test', function() 
{
 
it('Demo example',function() {

    //cy.visit("https://rahulshettyacademy.com/AutomationPractice/")
    cy.visit(Cypress.env('url')+"/AutomationPractice/")
    cy.frameLoaded('#courses-iframe')
    cy.iframe().find("a[href*='mentorship']").eq(0).click()
 

})
})