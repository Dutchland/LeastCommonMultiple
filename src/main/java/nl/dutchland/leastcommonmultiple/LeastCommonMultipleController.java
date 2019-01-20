package nl.dutchland.leastcommonmultiple;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeastCommonMultipleController {

    @RequestMapping("/leastcommonmultiple/from/{from}/until/{until}")
    public long leastCommonMultiple(@PathVariable(value="from") int from, @PathVariable(value="until") int until) {
        LeastCommonMultiple leastCommonMultiple = LeastCommonMultiple.ofInclusiveRange(from, until);
            return leastCommonMultiple.value().longValue();
    }
}
