import Vue from 'vue'

var app = new Vue({
    el: "#app",
    data: {
        selected: "Brazil",
        countryRate: 2.5,
        calc1: "",
        calc2: "",
        imageSrc: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/286148/",
        firstInputSelected: true,
        input: document.getElementById("currencyInput"),
        countries: [
            {
                name: "Brazil",
                money: "Reais",
                rate: 2.5,
                image: "flag-brazil.png"
            },
            {
                name: "UK",
                money: "Pounds",
                rate: 0.59,
                image: "flag-uk.png"
            },
            {
                name: "Germany",
                money: "Euro",
                rate: 0.67,
                image: "flag-germany.png"
            },
            {
                name: "USA",
                money: "USD",
                rate: 0.79,
                image: "flag-usa.png"
            },
            {
                name: "Canada",
                money: "CAD",
                rate: 0.94,
                image: "flag-canada.png"
            },
            {
                name: "New Zealand",
                money: "NZD",
                rate: 1.09,
                image: "flag-new-zealand.png"
            },
            {
                name: "Japanese",
                money: "YEN",
                rate: 88.51,
                image: "flag-japan.png"
            }
        ]
    },
    methods: {
        calcInput_1: function (e, rate) {
            this.firstInputSelected = true;
            this.calculate(e, rate);
        },
        calcInput_2: function (e, rate) {
            this.firstInputSelected = false;
            this.calculate(e, rate);
        },
        updateInputs: function () {
            var selected;
            for (let i = 0; i < this.countries.length; i++) {
                if (this.selected === this.countries[i].name) {
                    selected = this.countries[i];
                }
            }
            this.countryRate = selected.rate;

            var input2 = parseFloat(document.getElementById("currencyInput").value);
            if (isNaN(input2)) {
                this.calc2 = "";
                this.calc1 = "";
                return;
            }
            this.calc1 = (input2 * this.countryRate).toFixed(2);
        },
        calculate: function (e, value) {
            var value = parseFloat(e.target.value);
            if (isNaN(value)) {
                this.calc2 = "";
                this.calc1 = "";
                return;
            }

            if (this.firstInputSelected) {
                this.calc2 = value;
                this.calc1 = (value * this.countryRate).toFixed(2);
            } else {
                this.calc1 = value;
                this.calc2 = (value / this.countryRate).toFixed(2);
            }
        }
    }
});