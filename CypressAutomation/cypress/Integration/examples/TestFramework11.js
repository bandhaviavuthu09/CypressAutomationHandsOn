/// <reference types="Cypress" />

import HomePage from '../../support/pageObjects/HomePage' 
import ProductPage from '../../support/pageObjects/ProductPage' 

describe('My Second Test Suite', function() 
{
    before(function(){
        cy.fixture('example').then(function(data)
        {
            this.data=data
        })
    })

    it('My FirstTest case',function() {
        const homepage = new HomePage()
        const productpage = new ProductPage()
     
        cy.visit(Cypress.env('url')+"/angularpractice/")
        homepage.getEditBox().type(this.data.name)
        homepage.getGender().select(this.data.gender)
        homepage.getTwoWayDataBinding().should('have.value',this.data.name)
        homepage.getEditBox().should('have.attr','minlength','2')
        homepage.getEntrepreneaur().should('be.disabled')
        //cy.pause()
        homepage.getShopTab().click()
    
        this.data.productName.forEach(function(element) {
            cy.selectProduct(element)
        });
    
        productpage.checkOutButton().click()
        var sum=0
        cy.get('tr td:nth-child(4) strong').each(($e1, index, $list) =>{
            const amount=$e1.text()
            var res = amount.split(" ")
            res = res[1].trim()
            sum=Number(sum)+Number(res)
        }).then(function()
        {
            cy.log(sum)
        })

        cy.get('h3 strong').then(function(element)
        {
            const amount = element.text()
            var res = amount.split(" ")
            var total = res[1].trim()
            expect(Number(total)).to.equal(sum)
        })
 
        cy.contains('Checkout').click()
        cy.get('#country').type('India')
        cy.get('.suggestions > ul > li > a').click()
        cy.get('#checkbox2').click({force: true})
        cy.get('input[type="submit"]').click({force:true})
       // cy.get('.alert').should('have.text','Success! Thank you! Your order will be delivered in next few weeks :-).')
    
       cy.get('.alert').then(function(element)
        {
            const actualtext = element.text()
            var res=actualtext.split(" ")
            res = res[1].trim()
            cy.log(res)
            //expect(actualText.includes("Success")).to.be.true
        })
    
    })  
    })