aws_region   = "us-east-1"
project_name = "devops-microservice-project"
environment  = "dev"

key_name = "YOUR-EC2-KEY-NAME"

ec2_instance_type = "t3.small"

eks_node_instance_type = "c7i-flex.large"

eks_desired_nodes = 2
eks_min_nodes     = 1
eks_max_nodes     = 2