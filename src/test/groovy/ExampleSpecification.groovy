import spock.lang.Specification

class ExampleSpecification extends Specification {
    def "should be a simple assertion"() {
        expect:
        1 == 1
    }

    def "should demonstrate given-when-then"() {
        given:
        def polygon = new Polygon(4)

        when:
        def sides = polygon.numberOfSides

        then:
        sides == 4
    }
}