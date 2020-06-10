import { Pipe, PipeTransform } from '@angular/core';
import { Test } from './Test';

@Pipe({
  name: 'filterTest'
})
export class FilterTestPipe implements PipeTransform {

  transform(tests: Test[], search: string): Test[] {
    if(search === undefined) {
      return tests;
    } else {
      return tests.filter((value, index, array) => {
        return value.testName.toLowerCase().includes(search.toLowerCase());
      });
    }
  }
}
