import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-comp-c',
    template: 
    `<div>
        <h2>Aquí estoy c</h2>
        {{contador}} 
        <input type="button" (click)="alPulsarBtn()" value="+"/>
    </div>`
})
export class AppComponenteC {

    @Input() contador = 0;
    
    ngOnInit(){
    }

    alPulsarBtn(){
        this.contador ++;
        console.log("Contador = " + this.contador);
    }
}