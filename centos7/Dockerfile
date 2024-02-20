#MPROS's OS on Production is RHEL6   extk2in1@vimezmop-mpro07:PROD [~]$ cat /etc/*release -> Red Hat Enterprise Linux Server release 6.10 (Santiago)
FROM centos:7

WORKDIR /root

RUN yum groupinstall -y "Development Tools" \
  && yum install -y epel-release wget git bash libevent libevent-devel libaio yum-utils rsync sudo libselinux-utils\
  && yum install -y ncurses-devel openssl-devel wxGTK3-devel unixODBC-devel java-17-openjdk-devel
RUN curl https://dlcdn.apache.org/xmlgraphics/fop/binaries/fop-2.9-bin.tar.gz | tar xvzf - -C /usr/local/share/
ENV PATH="$PATH:/usr/local/share/fop-2.9/fop"


RUN wget https://packages.erlang-solutions.com/erlang-solutions-2.0-1.noarch.rpm && rpm -Uvh erlang-solutions-2.0-1.noarch.rpm && yum install -y esl-erlang-20.2.2-1

RUN mknod -m 644 /dev/random c 1 8 && mknod -m 644 /dev/urandom c 1 9 && chown root:root /dev/random /dev/urandom || echo "failed to make random - still ok"
RUN ln -s /usr/bin/escript /usr/bin/escript.exe

ARG BUILDER_UID=1001
ARG BUILDER_GID=1001

RUN groupadd -g $BUILDER_GID builder
RUN useradd -g $BUILDER_GID -u $BUILDER_UID -p 'builder' -m builder
RUN echo '%builder        ALL=(ALL)       NOPASSWD: ALL' > /etc/sudoers.d/builder

RUN mkdir /home/builder/.ssh 

ENV ERL_INTERFACE_DIR=/usr/lib/erlang/lib/erl_interface-3.10.1
ENV OTP_ERTS_DIR=/usr/lib/erlang/erts-9.2
RUN chown -R builder.builder /home/builder

USER builder
WORKDIR /home/builder

CMD /home/builder/runStart.sh
