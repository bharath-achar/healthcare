import { Pipe, PipeTransform } from '@angular/core';
import { Center } from './Center';

@Pipe({
  name: 'filterCenterPipes'
})
export class FilterCenterPipesPipe implements PipeTransform {

  transform(centers: Center[], search: string): Center[] {
    if(search === undefined) {
      return centers;
    } else {
      return centers.filter((value, index, array) => {
        return value.centerName.toLowerCase().includes(search.toLowerCase());
      });
    }
  }

}
