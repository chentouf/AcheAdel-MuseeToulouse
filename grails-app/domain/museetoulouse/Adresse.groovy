package museetoulouse

class Adresse {

    String numero
    String rue
    String codePostal
    String ville
    String state


    static constraints = {
        rue blank:false
        numero nullable: true
        codePostal blank:false
        ville blank:false
        state inList:["GA", "NC", "SC", "VA"], blank:false
    }

    String toString() {
        return (numero ?: '') +' '+rue+' '+codePostal+' '+ville;
    }
}
