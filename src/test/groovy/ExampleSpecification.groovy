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

    def "should expect Exceptions"() {
        when:
        new Polygon(0)

        then:
        def exception = thrown(TooFewSidesException)
        exception.numberOfSides == 0
    }

    def "should expect an Exception to be thrown for invalid input: #sides"() {
       when:
       new Polygon(sides)

        then:
        def exception = thrown(TooFewSidesException)
        exception.numberOfSides == sides

        where:
        sides << [-1, 0, 1, 2]
    }

    def "should be able to create a polygon with #sides sides"() {
        when:
        def polygon = new Polygon(sides)

        then:
        polygon.numberOfSides == sides

        where:
        sides << [3, 4, 5, 8, 13, 21]
    }

    def "should use data tables for calculating max. Max of #a and #b is #max"() {
        expect:
        Math.max(a, b) == max

        where:
        a | b || max
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 0
    }

    def "should be able to mock a concrete class"() {
        given:
        def renderer = Mock(Renderer)
        def polygon = new Polygon(4, renderer)

        when:
        polygon.draw()

        then:
        4 * renderer.drawLine()
    }

    def "should be able to create a stub"() {
        given: "a palette with red as the primary colour"
        def palette = Stub(Palette)
        palette.getPrimaryColour() >> Colour.Red

        and: "a renderer initialised with the red palette"
        def renderer = new Renderer(palette)

        expect: "the renderer to use the palette's primary colour as foreground"
        renderer.foregroundColour == Colour.Red
    }

    def "should use a helper method"() {
        given:
        def mockRenderer = Mock(Renderer)
        def shapeFactory = new ShapeFactory(mockRenderer)

        when:
        Polygon polygon = shapeFactory.createDefaultPolygon()

        then:
        verifyAll(polygon) {
            numberOfSides == 4
            renderer == mockRenderer
        }
    }
}
