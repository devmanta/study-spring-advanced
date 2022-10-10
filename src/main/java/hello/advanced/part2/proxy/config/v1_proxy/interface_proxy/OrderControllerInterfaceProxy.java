package hello.advanced.part2.proxy.config.v1_proxy.interface_proxy;

import hello.advanced.part1.trace.TraceStatus;
import hello.advanced.part1.trace.logtrace.LogTrace;
import hello.advanced.part2.proxy.app.v1.ProxyOrderControllerV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements ProxyOrderControllerV1 {

    private final ProxyOrderControllerV1 target;
    private final LogTrace trace;

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try{
            status = trace.begin("OrderControllerInterfaceProxy.request");
            String result = target.request(itemId);
            trace.end(status);
            return result;
        } catch(Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
