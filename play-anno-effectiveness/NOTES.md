测试注解用在不同位置里的效果。

六种注解的切点声明方式、切面获取注解值方式都相同，因此只需要使用一种注解进行测试就可以了。

```java
    // skip some code
    @Pointcut(value = "@within(Bulkhead) || @annotation(Bulkhead)", argNames = "Bulkhead")
    public void matchAnnotatedClassOrMethod(Bulkhead Bulkhead) {
    }

    @Around(value = "matchAnnotatedClassOrMethod(bulkheadAnnotation)", argNames = "proceedingJoinPoint, bulkheadAnnotation")
    public Object bulkheadAroundAdvice(ProceedingJoinPoint proceedingJoinPoint,
        @Nullable Bulkhead bulkheadAnnotation) throws Throwable {
        // skip some code
        if (bulkheadAnnotation == null) {
            bulkheadAnnotation = getBulkheadAnnotation(proceedingJoinPoint);
        }
        if (bulkheadAnnotation == null) { //because annotations wasn't found
            return proceedingJoinPoint.proceed();
        }
        // skip some code
    }

    // skip some code

    @Nullable
    private Bulkhead getBulkheadAnnotation(ProceedingJoinPoint proceedingJoinPoint) {
        if (logger.isDebugEnabled()) {
            logger.debug("bulkhead parameter is null");
        }
        if (proceedingJoinPoint.getTarget() instanceof Proxy) {
            logger.debug("The bulkhead annotation is kept on a interface which is acting as a proxy");
            return AnnotationExtractor.extractAnnotationFromProxy(proceedingJoinPoint.getTarget(), Bulkhead.class);
        } else {
            return AnnotationExtractor.extract(proceedingJoinPoint.getTarget().getClass(), Bulkhead.class);
        }
    }
```