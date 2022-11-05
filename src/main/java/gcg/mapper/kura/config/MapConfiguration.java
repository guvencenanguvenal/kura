package gcg.mapper.kura.config;

import java.util.List;

public class MapConfiguration {

    private List<SourceDestinationMap> maps;

    public void configure(List<SourceDestinationMap> maps) {
        this.maps = maps;
    }

    public void configure(SourceDestinationMap map) {
        this.maps = List.of(map);
    }

    public void configure(String sourceFieldName, String destinationFieldName) {
        this.maps = List.of(new SourceDestinationMap(sourceFieldName, destinationFieldName));
    }
}