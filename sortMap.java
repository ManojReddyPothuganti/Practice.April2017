
public static LinkedHashMap<String, Double> getWorstVehicle(List<Trip> trips){

Map<String, Double> averageMileageMap = trips.stream()
  .collect(groupingBy(Trip::getVehicleName, averagingDouble(Trip::getMileage)));


return averageMileageMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
                        }