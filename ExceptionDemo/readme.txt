>Exception is an unexpected event that occur in our code 
leading to termination, it is controllable unlike error
and happen at runtime
> It is an object which is thrown at runtime.

>exception handlinfg is a mechanism to handle errors such as class not found exception,
io exception,sql exception...

> exception handling is to maintain the normal flow of the application else termination happens


            /``Error (stack overflow,out of memory,virtual machine error)
>Throwable <
            \_Exception [SIC](IOEXception,SQLexception,ClassnotFoundException,
            RuntimeException)
                 \
                  Null pointer exception
                  Arithmetic exception
        [NANI]    Number format exception
                  IndexoutOfBoundException(ArrayindexOutOfException,StringOutOfException)
            
