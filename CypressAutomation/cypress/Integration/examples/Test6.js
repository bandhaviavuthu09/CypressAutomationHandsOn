/// <reference types="Cypress" />
 
describe('My Second Test Suite', function() 
{
 
it('My FirstTest case',function() {
 
//Check boxes
//cy.visit("https://rahulshettyacademy.com/AutomationPractice/")
cy.visit(Cypress.env('url')+"/AutomationPractice/")
cy.contains('Top').click({force:true})
cy.url().should('include','top')

})
})